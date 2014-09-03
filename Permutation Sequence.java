public class Solution {
    public String getPermutation(int n, int k) {
        if (k < 1) {
            return null;
        }
        
        int[] rec = new int[n + 2];
        rec[1] = 1;
        ArrayList<Character> num = new ArrayList<Character>();
        for (int i = 1; i <= n; i++) {
            rec[i + 1] = rec[i] * i;
            num.add((char)('0' + i));
        }
        k = (k - 1) % rec[n + 1];
        
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / rec[i];
            sb.append(num.get(index));
            num.remove(index);
            k %= rec[i];
        }

        return sb.toString();
    }
}

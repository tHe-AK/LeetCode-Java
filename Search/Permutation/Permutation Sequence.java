public class Solution {
    public String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k < 1) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[n];
        rec[0] = 1;
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        
        for (int i = 1; i < n; i++) {
            rec[i] = rec[i - 1] * i;
            sb.append((char)('1' + i));
        }
        
        if (k > rec[n - 1] * n) {
            throw new IllegalArgumentException();
        }
        
        k--;
        String result = new String();
        
        for (int i = n - 1; i >= 0; i--) {
            int index = k / rec[i];
            result += sb.charAt(index);
            sb.deleteCharAt(index);
            k -= index * rec[i];
        }
        
        return result;
    }
}
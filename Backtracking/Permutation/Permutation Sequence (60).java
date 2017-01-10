public class Solution {
    public String getPermutation(int n, int k) {
        int[] rec = new int[n];
        rec[0] = 1;
        List<Integer> list = new LinkedList<>();
        list.add(1);
        
        for (int i = 1; i < n; i++) {
            rec[i] = rec[i - 1] * i;
            list.add(i + 1);
        }
        
        k--;
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - 1; i >= 0; i--) {
            int index = k / rec[i];
            sb.append(list.get(index));
            list.remove(index);
            k -= index * rec[i];
        }
        
        return sb.toString();
    }
}

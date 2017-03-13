public class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] rec = new int[n + 1]; 
        
        for (int i = 0; i <= n; i++) {
            rec[i] = i + 1;
        }
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                int start = i++;
                
                while (i < n && s.charAt(i) == 'D') {
                    i++;
                }
                
                reverse(rec, start, i); 
            }
        }
        
        return rec;
    }   

    private void reverse(int[] rec, int low, int high) {
        while (low < high) {
            int temp = rec[low];
            rec[low++] = rec[high];
            rec[high--] = temp;
        }   
    }
}

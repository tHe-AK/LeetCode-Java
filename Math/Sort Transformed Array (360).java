public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0;
        int j = n - 1;
        int idx = a >= 0 ? n - 1 : 0;
        
        while (i <= j) {
            int val1 = quad(nums[i], a, b, c);
            int val2 = quad(nums[j], a, b, c);
            
            if (a >= 0) {
                if (val1 > val2) {
                    sorted[idx--] = val1;
                    i++;
                } else {
                    sorted[idx--] = val2;
                    j--;
                }
            } else {
                if (val1 < val2) {
                    sorted[idx++] = val1;
                    i++;
                } else {
                    sorted[idx++] = val2;
                    j--;
                }
            }
        }
        
        return sorted;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}

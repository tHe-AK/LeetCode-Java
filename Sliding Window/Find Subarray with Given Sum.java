public class Solution {
    public boolean subarray_sum(int[] array, int t) {
        if (array == null || array.length == 0) {
            return false;
        }
        
        int start = 0;
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            
            while (start <= i && sum >= t) {
                if (sum == t) {
                    return true;
                }
                else {
                    sum -= array[start];
                    start++;
                }
            }
        }
        
        return false;
    }
}

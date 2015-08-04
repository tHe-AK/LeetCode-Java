public class Solution {
    public boolean subarray_sum(int[] array, int t) {
        if (array == null || array.length == 0) {
            return false;
        }
        
        int low = 0;
        int high = 0;
        int sum = 0;
        
        while (low <= high && high < array.length) {
            while (high < array.length && sum < t) {
                sum += array[high];
                high++;
            }
            
            while (low <= high && sum >= t) {
                if (sum == t) {
                    return true;
                }
                else {
                    sum -= array[low];
                    low++;
                }
            }
        }
        
        return false;
    }
}

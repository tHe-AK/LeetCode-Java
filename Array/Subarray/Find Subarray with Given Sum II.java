public class Solution {
    public boolean subarray_sum(int[] array, int t) {
        if (array == null || array.length == 0) {
            return false;
        }
        
        HashSet<Integer> rec = new HashSet<Integer>();
        rec.add(0);
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            
            if (rec.contains(sum - t)) {
                return true;
            }
            else {
                rec.add(sum);
            }
        }
        
        return false;
    }
}

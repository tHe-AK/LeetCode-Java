public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);
        TreeMap<Integer, Integer> rec = new TreeMap<Integer, Integer>();
        int sum = 0;
        rec.put(sum, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (rec.containsKey(sum)) {
                result.set(0, rec.get(sum) + 1);
                result.set(1, i);
                
                return result;
            }
            else {
                rec.put(sum, i);
            }
        }
        
        int min = Integer.MAX_VALUE;
        Integer pre = null;
        
        for (Integer key : rec.keySet()) {
            if (pre != null && Math.abs(key - pre) < min) {
                min = Math.abs(key - pre);
                int index1 = rec.get(pre);
                int index2 = rec.get(key);
                result.set(0, Math.min(index1, index2) + 1);
                result.set(1, Math.max(index1, index2));
            }
            
            pre = key;
        }
        
        return result;
    }
}

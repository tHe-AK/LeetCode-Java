public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
        rec.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (rec.containsKey(sum)) {
                result.add(rec.get(sum) + 1);
                result.add(i);
                
                return result;
            }
            else {
                rec.put(sum, i);
            }
        }
        
        return result;
    }
}

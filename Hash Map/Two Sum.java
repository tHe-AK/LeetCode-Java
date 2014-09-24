public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        
        int[] result = new int[2];
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (rec.containsKey(target - numbers[i])) {
                result[0] = rec.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                
                return result;
            }
            
            rec.put(numbers[i], i);
        }
        
        return result;
    }
}
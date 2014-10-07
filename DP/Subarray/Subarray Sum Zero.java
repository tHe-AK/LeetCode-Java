public class Solution {
    public int[] subArraySumZero(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
        rec.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            
            if (rec.containsKey(sum)) {
                int[] result = new int[2];
                result[0] = rec.get(sum) + 1;
                result[1] = i;
                
                return result;
            }
            else {
                rec.put(sum, i);
            }
        }
        
        return null;
    }
}

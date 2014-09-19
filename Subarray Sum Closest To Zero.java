public class Solution {
    public int[] subArraySumClosestToZero(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int[] result = new int[2];
        SortedMap<Integer, Integer> rec = new TreeMap<Integer, Integer>();
        int sum = 0;
        rec.put(sum, -1);
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            
            if (rec.containsKey(sum)) {
                result[0] = rec.get(sum) + 1;
                result[1] = i;
                
                return result;
            }
            else {
                rec.put(sum, i);
            }
        }
        
        int min = Integer.MAX_VALUE;
        int index1;
        int index2;
        Integer pre = null;
        
        for (Integer key : rec.keySet()) {
            if (pre != null && Math.abs(key - pre) < min) {
                min = Math.abs(key - pre);
                index1 = rec.get(pre);
                index2 = rec.get(key);
                result[0] = Math.min(index1, index2) + 1;
                result[1] = Math.max(index1, index2);
            }
            
            pre = key;
        }
        
        return result;
    }
}

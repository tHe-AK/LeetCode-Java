public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        long result = 0;
        long factorial = 1;
        
        for (int i = len - 2; i >= 0; i--) {
            int count = 0;
            HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
            rec.put(A[i], 1);
            
            for (int j = i + 1; j < len; j++) {
                if (rec.containsKey(A[j])) {
                    rec.put(A[j], rec.get(A[j]) + 1);
                }
                else {
                    rec.put(A[j], 1);
                }
                
                if (A[i] > A[j]) {
                    count++;
                }
            }
            
            long dup = 1;
            
            for (Integer value : rec.values()) {
                long temp = 1;
                
                for (int x = 2; x <= value; x++) {
                    temp *= x;
                }
                
                dup *= temp;
            }
            
            result += count * factorial / dup;
            factorial *= len - i;
        }
        
        return result + 1;
    }
}

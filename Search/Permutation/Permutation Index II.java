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
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();

        for (int i = len - 1; i >= 0; i--) {
            if (rec.containsKey(A[i])) {
                rec.put(A[i], rec.get(A[i]) + 1);
            }
            else {
                rec.put(A[i], 1);
            }
            
            int count = 0;
            
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            
            long duplicate = 1;
            
            for (Integer value : rec.values()) {
                long temp = 1;
                
                for (int k = 2; k <= value; k++) {
                    temp *= k;
                }
                
                duplicate *= temp;
            }
            
            result += count * factorial / duplicate;
            factorial *= len - i;
        }
        
        return result + 1;
    }
}

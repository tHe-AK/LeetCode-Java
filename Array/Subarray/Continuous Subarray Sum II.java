public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int max = A[0];
        int cur = A[0];
        int sum = A[0];
        int start = 0;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);
        
        for (int i = 1; i < len; i++) {
            sum += A[i];
            
            if (cur + A[i] > A[i]) {
                cur += A[i];
                end = i;
            }
            else {
                cur = A[i];
                start = i;
                end = i;
            }
            
            if (cur > max) {
                max = cur;
                result.set(0, start);
                result.set(1, end);
            }
        }

        cur = A[0];
        start = 0;
        end = 0;
        
        for (int i = 1; i < len; i++) {
            if (cur + A[i] < A[i]) {
                cur += A[i];
                end = i;
            }
            else {
                cur = A[i];
                start = i;
                end = i;
            }
            
            if ((start != 0 && end != len - 1) && sum - cur > max) {
                max = sum - cur;
                result.set(0, (end + 1) % len);
                result.set(1, (start - 1) % len);
            }
        }
        
        return result;
    }
}

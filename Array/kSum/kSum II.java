public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (A == null || A.length < k) {
            return result;
        }
        
        Arrays.sort(A);
        
        helper(A, target, k, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] A, int target, int k, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        for (int i = start; i < A.length - k + 1; i++) {
            if (i != start && A[i] == A[i - 1]) {
                continue;
            }
                
            if (k > 1) {
                cur.add(A[i]);
                helper(A, target - A[i], k - 1, i + 1, cur, result);
                cur.remove(cur.size() - 1);
            }
            else {
                if (A[i] == target) {
                    cur.add(A[i]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(cur.size() - 1);
                    break;
                }
            }
        }
    }
}

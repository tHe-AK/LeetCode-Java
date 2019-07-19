class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1;
        
        while (i >= 0 || K > 0) {
            if (i >= 0) {
                K += A[i--];
            }
            
            res.add(0, K % 10);
            K /= 10;
        }
        
        return res;
    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean asc = true;
        boolean des = true;
        
        for (int i = 1; i < A.length; i++) {
            asc = asc && A[i - 1] <= A[i];
            des = des && A[i - 1] >= A[i];
            
            if (!asc && !des) {
                return false;
            }
        }
        
        return true;
    }
}

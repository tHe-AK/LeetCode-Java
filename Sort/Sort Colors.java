public class Solution {
    public void sortColors(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = A.length - 1;
        int cur = 0;
        
        while (cur <= high) {
            if (A[cur] == 0) {
                int temp = A[cur];
                A[cur] = A[low];
                A[low] = temp;
                low++;
                cur++;
            }
            else if (A[cur] == 2) {
                int temp = A[cur];
                A[cur] = A[high];
                A[high] = temp;
                high--;
            }
            else {
                cur++;
            }
        }
    }
}
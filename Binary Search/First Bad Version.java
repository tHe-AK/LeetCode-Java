/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        int low = 1;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (VersionControl.isBadVersion(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        if (low > n) {
            throw new IllegalArgumentException();
        }
        
        return low;
    }
}

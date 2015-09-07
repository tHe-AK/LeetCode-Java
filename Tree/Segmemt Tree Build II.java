/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        return helper(0, A.length - 1, A);
    }
    
    private SegmentTreeNode helper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode left  = helper(start, mid, A);
        SegmentTreeNode right = helper(mid + 1, end, A);
        SegmentTreeNode root = new SegmentTreeNode(start, end, Math.max(left.max, right.max));
        root.left = left;
        root.right = right;
        
        return root;
    }
}

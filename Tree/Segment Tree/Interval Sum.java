/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
 
class SegmentTreeNode {
    int start;
    int end;
    long sum;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
    
    public SegmentTreeNode(int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = null;
        this.right = null;
    }
}
 
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        SegmentTreeNode root = build(A, 0, A.length - 1);
        ArrayList<Long> result = new ArrayList<Long>();

        for (Interval i : queries) {
            result.add(query(root, i.start, i.end));
        }
        
        return result;
    }
    
    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        
        return root;
    }
    
    private long query(SegmentTreeNode root, int start, int end) {
        if (root == null || start < root.start || root.end < end) {
            throw new IllegalArgumentException();
        }
        
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (end <= mid) {
            return query(root.left, start, end);
        }
        else if (start > mid) {
            return query(root.right, start, end);
        }
        else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
}


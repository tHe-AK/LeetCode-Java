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
    SegmentTreeNode root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        root = build(A, 0, A.length - 1);
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
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return queryHelper(root, start, end);
    }
    
    public long queryHelper(SegmentTreeNode root, int start, int end) {
        if (root == null || start < root.start || root.end < end) {
            throw new IllegalArgumentException();
        }
        
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (end <= mid) {
            return queryHelper(root.left, start, end);
        }
        else if (start > mid) {
            return queryHelper(root.right, start, end);
        }
        else {
            return queryHelper(root.left, start, mid) + queryHelper(root.right, mid + 1, end);
        }
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modifyHelepr(root, index, value);
    }
    
    public void modifyHelepr(SegmentTreeNode root, int index, int value) {
        if (root == null || index < root.start || root.end < index) {
            return;
        }
        
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (index <= mid) {
            modifyHelepr(root.left, index, value);
        }
        else {
            modifyHelepr(root.right, index, value);
        }
        
        root.sum = root.left.sum + root.right.sum;
    }
}


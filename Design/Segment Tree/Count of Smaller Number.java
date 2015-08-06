class SegmentTreeNode {
    int start;
    int end;
    int count;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        SegmentTreeNode root = build(0, 10000);
        
        for (int i = 0; i < A.length; i++) {
            modify(root, A[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            result.add(query(root, queries[i] - 1));
        }
        
        return result;
    }
    
    private SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new SegmentTreeNode(start, end);
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(start, mid);
        root.right = build(mid + 1, end);

        return root;
    }
    
    private void modify(SegmentTreeNode root, int index) {
        if (root == null || index < root.start || root.end < index) {
            return;
        }
        
        if (root.start == index && root.end == index) {
            root.count++;
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (index <= mid) {
            modify(root.left, index);
        }
        else {
            modify(root.right, index);
        }
        
        root.count = root.left.count + root.right.count;
    }
    
    private int query(SegmentTreeNode root, int end) {
        if (root == null) {
            return 0;
        }
        
        if (root.end <= end) {
            return root.count;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (end <= mid) {
            return query(root.left, end);
        }
        else {
            return query(root.left, mid) + query(root.right, end);
        }
    }
}


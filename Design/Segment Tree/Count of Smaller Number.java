class SegmentTreeNode {
    int start;
    int end;
    int count;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
    
    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
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
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (A == null) {
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
            
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            
            if (rec.containsKey(A[i])) {
                rec.put(A[i], rec.get(A[i]) + 1);
            }
            else {
                rec.put(A[i], 1);
            }
        }
        
        SegmentTreeNode root = build(rec, min, max);
        
        for (int i = 0; i < queries.length; i++) {
            result.add(query(root, queries[i] - 1));
        }
        
        return result;
    }
    
    private SegmentTreeNode build(HashMap<Integer, Integer> rec, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            int count = 0;
            
            if (rec.containsKey(start)) {
                count = rec.get(start);
            }
            
            return new SegmentTreeNode(start, end, count);
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(rec, start, mid);
        root.right = build(rec, mid + 1, end);
        root.count = root.left.count + root.right.count;
        
        return root;
    }
    
    private int query(SegmentTreeNode root, int end) {
        if (root == null) {
            return 0;
        }
        
        if (root.end < end) {
            end = root.end;
        }
        
        if (root.end == end) {
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


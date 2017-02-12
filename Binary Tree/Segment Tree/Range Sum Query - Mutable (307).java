public class NumArray {
    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            updateDiff(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateDiff(i, diff);
    }
    
    private void updateDiff(int i, int diff) {
        i++;
        
        while (i < tree.length) {
            tree[i] += diff;
            i += i & -i;
        }
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    private int getSum(int i) {
        i++;
        int sum = 0;
        
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

class SegmentTreeNode {
    public int start;
    public int end;
    public int sum;
    public SegmentTreeNode left;
    public SegmentTreeNode right;

    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}
 
public class NumArray {
    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        } else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode left  = buildTree(nums, start, mid);
            SegmentTreeNode right = buildTree(nums, mid + 1, end);
            SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);
            root.left = left;
            root.right = right;
            
            return root;
        }
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == i && root.end == i) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            
            if (j <= mid) {
                return sumRange(root.left, i, j);
            } else if (i > mid) {
                return sumRange(root.right, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

public class NumArray {
    private int[] tree;
    private int n;
    
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    
    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
        }
        
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    
    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        
        while (i > 1) {
            int left = i;
            int right = i;
            
            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }

            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        i += n;
        j += n;
        int sum = 0;
        
        while (i <= j) {
            if (i % 2 == 1) {
               sum += tree[i];
               i++;
            }
            
            if (j % 2 == 0) {
               sum += tree[j];
               j--;
            }
            
            i /= 2;
            j /= 2;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

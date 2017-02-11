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

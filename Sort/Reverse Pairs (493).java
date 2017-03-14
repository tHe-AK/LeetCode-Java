public class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int result = 0;
        List<Integer> sorted = new ArrayList<>();
        
        for (int i = len - 1; i >= 0; i--) {
            result += binarySearch(sorted, nums[i] / 2.0);
            sorted.add(binarySearch(sorted, nums[i]), nums[i]);
        }
        
        return result;
    }
    
    private int binarySearch(List<Integer> nums, double num) {
        int low = 0;
        int high = nums.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums.get(mid) >= num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}

class TreeNode {
    public int val;
    public int same;
    public int count;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val, int same, int count) {
        this.val = val;
        this.same = same;
        this.count = count;
    }
}

public class Solution {
    public int reversePairs(int[] nums) {
        int result = 0;
        TreeNode root = null;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            result += search(root, nums[i] / 2.0);
            root = insert(root, nums[i]);
        }
        
        return result;
    }
    
    private int search(TreeNode root, double num) {
        if (root == null) {
            return 0;
        } else {
            if (root.val == num) {
                return root.count;
            } else if (root.val < num) {
                return root.same + root.count + search(root.right, num);
            } else {
                return search(root.left, num);
            }
        }
    }
    
    private TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num, 1, 0);
        } else {
            if (root.val == num) {
                root.same++;
            } else if (root.val < num) {
            	root.right = insert(root.right, num);
            } else {
                root.count++;
                root.left = insert(root.left, num);
            }
            
            return root;
        }
    }
}

public class Solution {
    public int reversePairs(int[] nums) {
        int[] count = new int[1];

        mergeSort(nums, 0, nums.length - 1, count);
        
        return count[0];
    }
    
    private int[] mergeSort(int[] nums, int start, int end, int[] count) {
        if (start > end) {
            return new int[0];
        } else if (start == end) {
            return new int[] { nums[start] };
        } else {
            int mid = start + (end - start) / 2;
            int m = mid - start + 1;
            int n = end - mid;
            
            int[] left = mergeSort(nums, start, mid, count);
            int[] right = mergeSort(nums, mid + 1, end, count);
            int[] sorted = new int[m + n];

            for (int i = 0, j = 0; i < m; i++) {
                while (j < n && left[i] > 2L * right[j]) {
                    j++;
                }
                
                count[0] += j;
            }
            
            for (int i = 0, j = 0, k = 0; k < m + n; k++) {
                if (i == m || (j < n && left[i] > right[j])) {
                    sorted[k] = right[j++];
                } else {
                    sorted[k] = left[i++];
                }
            }
            
            return sorted;
        }
    }
}

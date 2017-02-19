public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
    
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    
    private int findKthLargest(int[] nums, int k, int low, int high) {
        int pivot = nums[low];
        int idx = low + 1;
        
        for (int i = idx; i <= high; i++) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx++] = temp;
            }
        }
  
        int count = idx - low;
        nums[low] = nums[--idx];
        nums[idx] = pivot;
        
        if (count == k) {
            return nums[idx];
        } else if (count < k) {
            return findKthLargest(nums, k - count, idx + 1, high);
        } else {
            return findKthLargest(nums, k, low, idx - 1);
        }
    }
}

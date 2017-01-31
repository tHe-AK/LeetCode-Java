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
        int curr = low + 1;
        
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[curr];
                nums[curr++] = temp;
            }
        }
        
        nums[low] = nums[--curr];
        nums[curr] = pivot;
        
        int count = curr - low + 1;
        
        if (count == k) {
            return nums[curr];
        }
        else if (count < k) {
            return findKthLargest(nums, k - count, curr + 1, high);
        }
        else {
            return findKthLargest(nums, k, low, curr - 1);
        }
    }
}

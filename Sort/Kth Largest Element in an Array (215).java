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
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    private int findKthLargest(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int idx = start + 1;
        
        for (int i = idx; i <= end; i++) {
            if (nums[i] >= pivot) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
        
        nums[start] = nums[--idx];
        nums[idx] = pivot;
        int count = idx - start + 1;
        
        if (count == k) {
            return pivot;
        } else if (count < k) {
            return findKthLargest(nums, idx + 1, end, k - count);
        } else {
            return findKthLargest(nums, start, idx - 1, k);
        }
    }
}

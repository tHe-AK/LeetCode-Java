public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();
        int n = nums.length - k + 1;
        double[] result = new double[n];
        
        for (int i = 0; i < nums.length; i++) {
            int add = nums[i];

            if (i <= k - 1) {
                max.offer(add);
                min.offer(max.poll());
                    
                if (max.size() < min.size()) {
                    max.offer(min.poll());
                }
                
                if (i == k - 1) {
                    result[0] = findMedian(k, max, min);
                }
            } else {
                int remove = nums[i - k];
                int diff = remove <= max.peek() ? -1 : 1;
                map.put(remove, map.getOrDefault(remove, 0) + 1);

                if (max.isEmpty() || add <= max.peek()) {
                    diff++;
                    max.offer(add);
                    
                    if (diff > 0) {
                        min.offer(max.poll());
                    } 
                } else {
                    diff--;
                    min.offer(add);
                    
                    if (diff < 0) {
                        max.offer(min.poll());
                    }
                }
                
                removeNum(map, max);
                removeNum(map, min);
                result[i - k + 1] = findMedian(k, max, min);
            }
        }
        
        return result;
    }
    
    private double findMedian(int k, Queue<Integer> max, Queue<Integer> min) {
        return k % 2 == 0 ? ((double) max.peek() + min.peek()) / 2 : max.peek();
    }
    
    private void removeNum(Map<Integer, Integer> map, Queue<Integer> queue) {
        while (!queue.isEmpty() && map.containsKey(queue.peek())) {
            int key = queue.poll();
                    
            if (map.get(key) == 1) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
    }
}

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<Integer>();
        
        int n = nums.length - k + 1;
        double[] result = new double[n];
        
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i], max, min);
            int idx = i - k + 1;
            
            if (idx >= 0) {
                result[idx] = findMedian(max, min);
                removeNum(nums[idx], max, min);
            }
        }
        
        return result;
    }
    
    private void addNum(int num, Queue<Integer> max, Queue<Integer> min) {
        if (max.isEmpty() || num <= max.peek()) {
            max.offer(num);
        } else {
            min.offer(num);
        }
        
        shift(max, min);
    }
    
    private void removeNum(int num, Queue<Integer> max, Queue<Integer> min) {
        if (num <= max.peek()) {
            max.remove(num);
        } else {
            min.remove(num);
        }
        
        shift(max, min);
    }
    
    private double findMedian(Queue<Integer> max, Queue<Integer> min) {
        return max.size() == min.size() ? ((double) max.peek() + min.peek()) / 2 : max.peek();
    }
    
    private void shift(Queue<Integer> max, Queue<Integer> min) {
        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        } 
        
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
}

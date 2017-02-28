public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            if (set.add(i)) {
                pq.offer(i);

                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}

public class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer n : nums) {
            if (!n.equals(max1) && !n.equals(max2) && !n.equals(max3)) {
                if (max1 == null || n > max1) {
                    max1 = n;
                    max2 = max1;
                    max3 = max2;
                } else if (max2 == null || n > max2) {
                    max2 = n;
                    max3 = max2;
                } else if (max3 == null || n > max3) {
                    max3 = n;
                }
            }
        }
        
        return max3 == null ? max1 : max3;
    }
}

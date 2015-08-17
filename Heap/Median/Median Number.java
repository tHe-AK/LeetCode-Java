public class Solution { 
    public void medianNumber(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(num.length / 2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        
        for (int i = 0; i < num.length; i++) {
            if (max.isEmpty() || num[i] <= max.peek()) {
                max.offer(num[i]);
            }
            else {
                min.offer(num[i]);
            }
            
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }
            
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
            
            System.out.println((max.size() + min.size()) % 2 == 0 ? (max.peek() + min.peek()) / 2.0 : max.peek());
        }
    }
}

public class MedianFinder {
    Queue<Integer> max; 
    Queue<Integer> min;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<Integer>((a, b) -> b - a);
        min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
            
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

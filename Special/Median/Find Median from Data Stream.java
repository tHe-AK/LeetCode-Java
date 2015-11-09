class MedianFinder {
    Queue<Integer> max; 
    Queue<Integer> min;
        
    public MedianFinder() {
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
        min = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
            
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.isEmpty()) {
            throw new RuntimeException("No data");
        }
        
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

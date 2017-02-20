public class MovingAverage {
    private int[] window;
    private int idx;
    private double sum;
    private int count;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        idx = 0;
        sum = 0;
        count = 0;
    }
    
    public double next(int val) {
        if (count < window.length) {
            count++;
        }
        
        sum -= window[idx];
        sum += val;
        window[idx] = val;
        idx = (idx + 1) % window.length;
        
        return sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

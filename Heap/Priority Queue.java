public class PriorityQueue {
    private int[] array;
    private int capacity;
    private int size;
    private Comparator<Integer> comparator;
    
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity + 1];
        size = 0;
        comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
    }
    
    public int size() {
        return size;
    }
    
    public boolean empty() {
        return size == 0;
    }
    
    public void offer(int val) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full.");
        }
        
        size++;
        array[size] = val;
        shiftUp(size);
    }
    
    public int poll() {
        if (empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        
        int val = array[1];
        swap(1, size);
        array[size] = 0;
        size--;
        
        if (size >= 1) {
            shiftDown(1);
        }
        
        return val;
    }
    
    public int peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        
        return array[1];
    }
    
    private void shiftUp(int i) {
        while (i > 1 && comparator.compare(array[i / 2], array[i]) > 0) {
            swap(i, i / 2);
            i = i / 2;
        }
    }
    
    private void shiftDown(int i) {
        while (2 * i <= size) {
            int index = (2 * i + 1 > size || comparator.compare(array[2 * i], array[2 * i + 1]) < 0) ? 2 * i : 2 * i + 1;

            if (comparator.compare(array[i], array[index]) > 0) {
                swap(i, index);
                i = index;
            }
            else {
                break;
            }
        }
    }
    
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

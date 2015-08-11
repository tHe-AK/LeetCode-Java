public class PriorityQueue {
    private int[] array;
    private int capacity;
    private int size;
    private MyComparator myComparator;
    
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity + 1];
        size = 0;
        myComparator = new MyComparator();
    }
    
    private class MyComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
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
        shiftUp();
    }
    
    public int poll() {
        if (empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        
        int val = array[1];
        swap(1, size);
        array[size] = 0;
        size--;
        
        if (size > 0) {
            shiftDown();
        }
        
        return val;
    }
    
    public int peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        
        return array[1];
    }
    
    private void shiftUp() {
        int i = size;
        
        while (i > 1 && myComparator.compare(array[i / 2], array[i]) > 0) {
            swap(i, i / 2);
            i = i / 2;
        }
    }
    
    private void shiftDown() {
        int i = 1;
        
        while (2 * i <= size) {
            int index = (2 * i + 1 > size || myComparator.compare(array[2 * i], array[2 * i + 1]) < 0) ? 2 * i : 2 * i + 1;

            if (myComparator.compare(array[i], array[index]) > 0) {
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

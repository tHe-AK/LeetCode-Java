class MyCircularDeque {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        front = 0;
        rear = k - 1;
        capacity = k;
        size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            front = (front - 1 + capacity) % capacity;
            queue[front] = value;
            size++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : queue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : queue[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

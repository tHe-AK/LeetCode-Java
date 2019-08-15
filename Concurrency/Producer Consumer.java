import java.util.*;

class Solution {
    private Queue<Integer> queue;
    private int num;
    private int max;

    public Solution(int max) {
        queue = new LinkedList<>();
        num = 0;
        this.max = max;
    }

    public void produce() {
        while (true) {
            synchronized (this) {
                try {
                    while (queue.size() == max) {
                        wait();
                    }

                    System.out.println("Produce: " + num);
                    queue.offer(num++);
                    notify();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                try {
                    while (queue.isEmpty()) {
                        wait();
                    }

                    System.out.println("Consume: " + queue.poll());
                    notify();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution pc = new Solution(2);
        Thread t1 = new Thread() {
            public void run() {
                pc.produce();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                pc.consume();
            }
        };
        t1.start();
        t2.start();
    }
}

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Solution {
    private Queue<Integer> queue;
    private int num;
    private int max;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;

    public Solution(int max) {
        queue = new LinkedList<>();
        num = 0;
        this.max = max;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void produce() {
        while (true) {
            lock.lock();
            
            try {
                while (queue.size() == max) {
                    notFull.await();
                }

                System.out.println("Produce: " + num);
                queue.offer(num++);
                notEmpty.signal();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    
    public void consume() {
        while (true) {
            lock.lock();
            
            try {
                while (queue.isEmpty()) {
                    notEmpty.await();
                }

                System.out.println("Consume: " + queue.poll());
                notFull.signal();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Solution pc = new Solution(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Runnable() {
            public void run() {
                pc.produce();
            }
        });
        executor.submit(new Runnable() {
            public void run() {
                pc.consume();
            }
        });
    }
}

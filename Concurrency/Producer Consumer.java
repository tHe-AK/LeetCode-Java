import java.util.*;

class ProducerConsumer {
    private Queue<Integer> queue;
    private int num;
    private int max;

    public ProducerConsumer(int max) {
        queue = new LinkedList<>();
        num = 0;
        this.max = max;
    }

    public synchronized void produce() {
        while (true) {
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
    
    public synchronized void consume() {
        while (true) {
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

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(2);
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

class Solution {
    private int num;
    private int max;

    public Solution(int max) {
        num = 0;
        this.max = max;
    }

    public void print(int k) {
        while (true) {
            synchronized (this) {
                try {
                    while (num <= max && num % 2 == k) {
                        wait();
                    }

                    if (num > max) {
                        break;
                    }

                    System.out.println(num++);
                    notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution printer = new Solution(100);
        Thread t1 = new Thread() {
            public void run() {
                printer.print(0);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                printer.print(1);
            }
        };
        t1.start();
        t2.start();
    }
}

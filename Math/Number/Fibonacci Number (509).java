class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        
        int first = 0;
        int second = 1;
            
        for (int i = 2; i <= N; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        
        return second;
    }
}

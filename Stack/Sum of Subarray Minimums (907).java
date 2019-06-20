class Solution {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Stack<int[]> stack1 = new Stack<>();
        stack1.push(new int[] { 0, -1 });
        Stack<int[]> stack2 = new Stack<>();
        stack2.push(new int[] { 0, N });
        int[] left = new int[N];
        int[] right = new int[N];
        long res = 0;
        
        for (int i = 0; i < N; i++) {
            int val1 = A[i];
            int j = N - i - 1;
            int val2 = A[j];
                        
            while (!stack1.empty() && stack1.peek()[0] >= val1) {
                stack1.pop();
            }
            
            left[i] = i - stack1.peek()[1];
            stack1.push(new int[] { val1, i });

            while (!stack2.empty() && stack2.peek()[0] > val2) {
                stack2.pop();
            }
            
            right[j] = stack2.peek()[1] - j;
            stack2.push(new int[] { val2, j });
        }
        
        for (int i = 0; i < N; i++) {
            res = (res + (1L * left[i] * right[i] * A[i] % MOD)) % MOD;
        }
        
        return (int) res;
    }
}

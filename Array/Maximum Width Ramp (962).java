class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        
        for (int i =N - 1; i > max; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                max = Math.max(max, i - stack.pop());
            }
        }
        
        return max;
    }
}

class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] array = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        
        Arrays.sort(array, (i, j) -> Integer.compare(A[i], A[j]));
        int min = array[0];
        int max = 0;
        
        for (int i = 1; i < N; i++) {
            max = Math.max(max, array[i] - min);
            min = Math.min(min, array[i]);
        }
        
        return max;
    }
}

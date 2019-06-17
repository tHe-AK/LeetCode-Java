class RLEIterator {
    private int[] A;
    private int idx;

    public RLEIterator(int[] A) {
        this.A = A;
        this.idx = 0;
    }
    
    public int next(int n) {
        while (idx < A.length && n > A[idx]) {
            n -= A[idx];
            idx += 2;
        }
        
        if (idx == A.length) {
            return - 1;
        }
        
        A[idx] -= n;
        return A[idx + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */

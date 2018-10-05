class Solution {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }
}

class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        } else {
            int digit = kthGrammar(N - 1, (K + 1) / 2);
            boolean isEven = (K & 1) == 0;
            
            if (digit == 0) {
                return isEven ? 1 : 0;
            } else {
                return isEven ? 0 : 1;
            }
        }
    }
}

class Solution {
    public int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N <= 4) {
            return N + 3;
        } else {
            if ((N - 4) % 4 == 0) {
                return N + 1;
            } else if ((N - 4) % 4 <= 2) {
                return N + 2;
            } else {
                return N - 1;
            }
        }
    }
}

class Solution {
    public int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N <= 3) {
            return N + 3;
        } else {
            return N * (N - 1) / (N - 2) + N - 3 + helper(N - 4);
        }
    }
    
    private int helper(int N) {
        if (N <= 2) {
            return -N;
        } else if (N <= 3) {
            return -6;
        } else {
            return -N * (N - 1) / (N - 2) + N - 3 + helper(N - 4);
        }
    }
}

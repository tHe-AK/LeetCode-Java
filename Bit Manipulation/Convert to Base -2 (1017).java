class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}

class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        
        while (N != 0) {
            int remaining = N % (-2);
            N /= -2;
            
            if (remaining < 0) {
                remaining += 2;
                N++;
            }
            
            sb.append(remaining);
        }
        
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}

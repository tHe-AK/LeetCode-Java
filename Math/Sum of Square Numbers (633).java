public class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int)Math.sqrt(c);
        
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        
        return false;
    }
}

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - (int)(a * a));
            
            if (b == (int) b) {
                return true;
            }
        }
        
        return false;
    }
}

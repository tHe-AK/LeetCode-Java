public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || (n & 3) == 1) {
                n--;
            } else {
                n++;
            }
            
            count++;
        }
        
        return count;
    }
}

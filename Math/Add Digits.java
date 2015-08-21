public class Solution {
    public int addDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        return (num - 1) % 9 + 1;
    }
}

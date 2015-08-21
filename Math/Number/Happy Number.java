public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        HashSet<Integer> rec = new HashSet<Integer>();

        while (!rec.contains(n)) {
            rec.add(n);
            
            if (n == 1) {
                return true;
            }
            
            n = helper(n);
        }
        
        return false;
    }
    
    private int helper(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}

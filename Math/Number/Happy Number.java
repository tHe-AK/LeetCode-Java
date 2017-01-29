public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> rec = new HashSet<>();

        while (rec.add(n)) {            
            if (n == 1) {
                return true;
            }
            
            n = getSum(n);
        }
        
        return false;
    }
    
    private int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}

public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {            
            slow = getSum(slow);
            fast = getSum(getSum(fast));
            
            if (slow == fast) {
                return slow == 1;
            }
        }
    }
    
    private int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}

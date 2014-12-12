public class Solution {
    public void findFactors(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        if (num <= 1) {
            System.out.println(num);
            return;
        }
        
        System.out.println(1 + "*" + num);
        
        helper(num, 2, "");
    }
    
    private void helper(int num, int start, String pre) {
        for (int i = start; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(pre + i + "*" + num / i);
                helper(num / i, i, pre + i + "*");
            }
        }
    }
}
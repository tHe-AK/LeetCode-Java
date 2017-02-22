public class Solution {
    private int base = 1337;
    
    public int superPow(int a, int[] b) {
        int result = 1;
        
        for (int digit : b) {
            result = powMod(result, 10) * powMod(a, digit) % base;
        }
        
        return result;
    }
    
    private int powMod(int a, int b) {
        int result = 1;
        
        for (int i = 0; i < b; ++i)
            result = result * (a % base) % base;
            
        return result;
    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int curr = 0;
        int max = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                curr += customers[i];
            }
            
            if (i >= X) {
                curr -= customers[i - X] * grumpy[i - X];
            }
            
            max = Math.max(max, curr);
        }
        
        return sum + max;
    }
}

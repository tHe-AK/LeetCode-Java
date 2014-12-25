public class Solution {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int majority = num[0];
        int count = 1;
        
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                majority = num[i];
                count = 1;
            }
            else if (num[i] == majority) {
                count++;
            }
            else {
                count--;
            }
        }
        
        if (count != 0) {
            count = 0;
            
            for (int i = 0; i < num.length; i++) {
                if (num[i] == majority) {
                    count++;
                }
            }
            
            if (count > num.length / 2) {
                return majority;
            }
        }
        
        throw new IllegalArgumentException();
    }
}
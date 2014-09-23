public class Solution {
    public int majorityNumber(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        Integer candidate = null;
        int count = 0;
        
        for (int i = 0; i < num.length; i++) {
            if (candidate == null) {
                candidate = num[i];
                count = 1;
            }
            else if (candidate == num[i]) {
                count++;
            }
            else {
                count--;
                
                if (count == 0) {
                    candidate = null;
                }
            }
        }
        
        if (candidate != null) {
            count = 0;
            
            for (int i = 0; i < num.length; i++) {
                if (num[i] == candidate) {
                    count++;
                }
            }
            
            if (count > num.length / 2) {
                return candidate;
            }
        }
        
        throw new RuntimeException("Input is not valid.");
    }
}

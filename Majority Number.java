public class Solution {
    public int majorityNumber(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int candidate = num[0];
        int count = 1;
        int i = 1;
        
        while (i < num.length) {
            if (num[i] != candidate) {
                count--;
            }
            else {
                count++;
            }
            
            i++;
            
            if (count == 0) {
                if (i >= num.length) {
                    throw new RuntimeException("Does not exist.");
                }
                
                candidate = num[i];
                count = 1;
                i++;
            }
        }
        
        return candidate;
    }
}

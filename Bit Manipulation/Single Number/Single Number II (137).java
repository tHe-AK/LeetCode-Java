public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        
        for (int num : nums){
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        
        return one;
    }
}

public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            
            one |= (count % 3) << i;
        }
        
        return one;
    }
}

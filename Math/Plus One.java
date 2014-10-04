public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            throw new IllegalArgumentException();
        }
        
        int len = digits.length;
        int[] rec = new int[len];
        int carry = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            carry += digits[i];
            rec[i] = carry % 10;
            carry /= 10;
        }
        
        if (carry == 1) {
            int[] result = new int[len + 1];
            result[0] = carry;
            System.arraycopy(rec, 0, result, 1, rec.length);
            
            return result;
        }
        else {
            return rec;
        }
    }
}
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }
        
        int cur1 = a.length() - 1;
        int cur2 = b.length() - 1;
        int carry = 0;
        String result = new String();
        
        while (cur1 >= 0 || cur2 >= 0 || carry > 0) {
            if (cur1 >= 0) {
                carry += a.charAt(cur1) - '0';
                cur1--;
            }
            
            if (cur2 >= 0) {
                carry += b.charAt(cur2) - '0';
                cur2--;
            }
            
            result = carry % 2 + result;
            carry /= 2;
        }
        
        return result;
    }
}
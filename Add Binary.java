public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        else if (b == null || b.length() == 0) {
            return a;
        }
        
        int pos1 = a.length() - 1;
        int pos2 = b.length() - 1;
        int carry = 0;
        String result = "";
        while (pos1 >= 0 || pos2 >= 0 || carry == 1) {
            int sum = carry;
            if (pos1 >= 0) {
                sum += a.charAt(pos1) - '0';
                pos1--;
            }
            if (pos2 >= 0) {
                sum += b.charAt(pos2) - '0';
                pos2--;
            }
            
            carry = sum / 2;
            result = sum % 2 + result;
        }
        
        return result;
    }
}

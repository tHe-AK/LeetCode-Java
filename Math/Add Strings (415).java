public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            carry += i >= 0 ? num1.charAt(i) - '0' : 0;
            carry += j >= 0 ? num2.charAt(j) - '0' : 0;
            
            sb.append(carry % 10);
            carry = carry / 10;
            i--;
            j--;
        }
        
        return sb.reverse().toString();
    }
}

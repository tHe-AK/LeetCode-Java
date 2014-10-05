public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] rec = new int[len1 + len2];
        
        for (int j = len2 - 1; j >= 0; j--) {
            int cur2 = num2.charAt(j) - '0';
            int carry = 0;
            int i;
            
            for (i = len1 - 1; i >= 0; i--) {
                int cur1 = num1.charAt(i) - '0';
                carry += cur2 * cur1 + rec[j + i + 1];
                rec[j + i + 1] = carry % 10;
                carry /= 10;
            }
            
            rec[j + i + 1] += carry;
        }
        
        String result = "";
        
        int i = 0;
        
        while (i < rec.length - 1 && rec[i] == 0) {
            i++;
        }
        
        while (i < rec.length) {
            result += rec[i];
            i++;
        }
        
        return result;
    }
}
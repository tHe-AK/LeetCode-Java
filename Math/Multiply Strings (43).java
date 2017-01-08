public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] rec = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index1 = i + j;
                int index2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + rec[index2];
    
                rec[index1] += sum / 10;
                rec[index2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rec.length; i++) {
            if (i == rec.length - 1 || sb.length() != 0 || rec[i] != 0) {
                sb.append(rec[i]);
            }
        }
        
        return sb.toString();
    }
}

public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] rec = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int idx1 = i + j;
                int idx2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + rec[idx2];
    
                rec[idx1] += sum / 10;
                rec[idx2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < rec.length - 1 && rec[i] == 0) {
            i++;
        }
        
        while (i < rec.length) {
            sb.append(rec[i++]);
        }
        
        return sb.toString();
    }
}

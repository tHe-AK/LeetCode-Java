import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        
        for (int i = 0; i < len; i++) {
            if (i == 0 || num.charAt(0) != '0') {
                for (int j = i + 1; j < len; j++) {
                    if ((j == i + 1 || num.charAt(i + 1) != '0') && j + 1 < len) {
                        BigInteger num1 = new BigInteger(num.substring(0, i + 1));
                        BigInteger num2 = new BigInteger(num.substring(i + 1, j + 1));
                        
                        if (isValid(num, j + 1, num1, num2)) {
                            return true;
                        }
                    }
                }
            }
        }
            
        return false;
    }
    
    private boolean isValid(String num, int start, BigInteger num1, BigInteger num2) {
        BigInteger sum = num1.add(num2);

        while (start < num.length() && num.startsWith(sum.toString(), start)) {
            start += sum.toString().length();
            num1 = num2;
            num2 = sum;
            sum = num1.add(num2);
        }
        
        return start == num.length();
    }
}

public class Solution {
    public String intToRoman(int num) {
        String[] key = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                sb.append(key[i]);
                num -= val[i];
            }
        }
        
        return sb.toString();
    }
}

public class Solution {
    public String intToRoman(int num) {
        String[] M = { "", "M", "MM", "MMM" };
        String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }
}

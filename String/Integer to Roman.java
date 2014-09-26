public class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException();
        }
        
        String[] key = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        
        String result = new String();
        
        while (num > 0) {
            for (int i = 0; i < val.length; i++) {
                if (val[i] <= num) {
                    result += key[i];
                    num -= val[i];
                    break;
                }
            }
        }
        
        return result;
    }
}
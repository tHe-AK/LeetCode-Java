class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] idx = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            idx[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (idx[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[idx[j]];
                    digits[idx[j]] = temp;
                    
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        
        return num;
    }
}

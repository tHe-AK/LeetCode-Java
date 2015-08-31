public class Solution {
    public String numberToWords(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        if (num == 0) {
            return "Zero";
        }

        int[] recNum = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};
        String[] recStr = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int[] dividendNum = new int[] {1, 1000, 1000000, 1000000000};
        String[] dividendStr = new String[] {"", "Thousand", "Million", "Billion"};
        StringBuilder sb = new StringBuilder();
        
        for (int level = dividendNum.length - 1; level >= 0; level--) {
            int val = num / dividendNum[level] % 1000;
            
            if (val > 0) {
                helper(recNum, recStr, val, level, sb);
                sb.append(dividendStr[level]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
    
    private void helper(int[] recNum, String[] recStr, int val, int level, StringBuilder sb) {    
        int digit = val / 100;
        
        if (digit > 0) {
            sb.append(recStr[digit]);
            sb.append(" ");
            sb.append("Hundred ");
        }
        
        val %= 100;
        
        for (int i = recNum.length - 1; i > 0 && val > 0; i--) {
            if (recNum[i] <= val) {                  
                sb.append(recStr[i]);
                sb.append(" ");
                val -= recNum[i];
            }
        }
    }
}

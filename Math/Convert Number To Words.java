import java.io.*;
import java.util.*;

class Solution {
    public String covertNum2Words(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n == 0) {
            return "zero";
        }

        int[] recNum = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};
        String[] recStr = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int[] dividendNum = new int[] {1, 1000, 1000000, 1000000000};
        String[] dividendStr = new String[] {"", "thousand", "million", "billion"};
        StringJoiner sj = new StringJoiner(" ");
        
        for (int level = dividendNum.length - 1; level >= 0; level--) {
            int val = n / dividendNum[level] % 1000;
            
            if (level == 0 && n >= 1000 && val > 0 && val < 100) {
                sj.add("and");
            }
            
            helper(recNum, recStr, dividendStr, val, level, sj);
        }
        
   
        return sj.toString();
    }
    
    private void helper(int[] recNum, String[] recStr, String[] dividendStr, int val, int level, StringJoiner sj) {    
        if (val == 0) {
            return;
        }
        
        int digit = val / 100;
        
        if (digit > 0) {
            sj.add(recStr[digit]);
            sj.add("hundred");
        }
        
        val %= 100;
        
        if (digit > 0 && val > 0) {
            sj.add("and");
        }
        
        for (int i = recNum.length - 1; i > 0 && val > 0; i--) {
            if (recNum[i] <= val) {                  
                sj.add(recStr[i]);
                val -= recNum[i];
            }
        }
        
        sj.add(dividendStr[level]);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.covertNum2Words(1234567089));
    }
}

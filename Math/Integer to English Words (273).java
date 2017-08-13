public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String[] one = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String[] ten = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] thousand = { "", "Thousand", "Million", "Billion" };
        String result = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                result = numberToWords(num % 1000, one, ten).trim() + " " + thousand[i] + " " + result;
            }
            
    	    num /= 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String numberToWords(int num, String[] one, String[] ten) {
        if (num < 20) {
            return one[num];
        } else if (num < 100) {
            return ten[num / 10] + " " + numberToWords(num % 10, one, ten);
        } else {
            return one[num / 100] + " Hundred " + numberToWords(num % 100, one, ten);
        }
    }
}

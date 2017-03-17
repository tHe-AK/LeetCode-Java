public class Solution {
    public String convertToBase7(int num) {
        if (num < 0) {
            return '-' + convertToBase7(-num);
        } else if (num < 7) {
            return num + "";
        } else {
            return convertToBase7(num / 7) + num % 7;
        }
    }
}

public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        
        if (num < 0) {
            num = -num;
            negative = true;
        }
        
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        
        if (negative) {
            sb.append("-");
        }
        
        return sb.reverse().toString();
    }
}

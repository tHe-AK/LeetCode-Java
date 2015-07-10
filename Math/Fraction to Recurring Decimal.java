public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        if (denominator == 0) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        
        num = Math.abs((long) numerator);
        den = Math.abs((long) denominator);
        sb.append(num / den);
        
        if (num % den == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        num = num % den * 10;
        HashMap<Long, Integer> rec = new HashMap<Long, Integer>();
        
        while (num != 0) {
            if (rec.containsKey(num)) {
                sb.insert(rec.get(num), "(");
                sb.append(")");
                return sb.toString();
            }
            else {
                rec.put(num, sb.length() - 1);
                sb.append(num / den);
                num = num % den * 10;
            }
        }
        
        return sb.toString();
    }
}

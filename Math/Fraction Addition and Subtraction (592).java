public class Solution {
    public String fractionAddition(String expression) {
        List<Integer> signs = new ArrayList<>();
        
        if (expression.length() > 0 && expression.charAt(0) != '-') {
            expression = "+" + expression;
        }
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == '+') {
                signs.add(1);
            } else if (ch == '-') {
                signs.add(-1);
            }
        }
        
        int num = 0;
        int den = 1;
        String[] strs = expression.split("(\\+)|(-)");
        
        for (int i = 1; i < strs.length; i++) {
            String[] fractions = strs[i].split("/");
            int currNum = Integer.parseInt(fractions[0]);
            int currDen = Integer.parseInt(fractions[1]);
            int gcd = GCD(den, currDen);
            num = num * currDen / gcd + signs.get(i - 1) * currNum * den / gcd;
            den = den * currDen / gcd;
            gcd = Math.abs(GCD(num, den));
            num /= gcd;
            den /= gcd;
        }
        
        return num + "/" + den;
    }
    
    private int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }
}

public class Solution {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] left = parse(strs[0]);
        int[] right = parse(strs[1]);
        int a = left[0] - right[0];
        int b = right[1] - left[1];

        if (a == 0 && b == 0) {
            return "Infinite solutions";
        } else if (a == 0) {
            return "No solution";
        } else {
            return "x=" + b / a;
        }
    }
    
    private int[] parse(String str) {
        String[] tokens = str.split("(?=[-+])"); 
        int[] res = new int[2];
                             
        for (String token : tokens) {
            if (token.equals("x") || token.equals("+x")) {
                res[0] += 1;
            } else if (token.equals("-x")) {
                res[0] -= 1;
            } else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                res[1] += Integer.parseInt(token);
            }
        }
        
        return res;
    }
}

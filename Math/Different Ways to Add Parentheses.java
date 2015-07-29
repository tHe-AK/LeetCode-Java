public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        result.add(helper(cur, left.get(j), right.get(k)));
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
            return result;
        }
        
        return result;
    }
    
    private int helper(char opr, int left, int right) {
        if (opr == '+') {
            return left + right;
        }
        else if (opr == '-') {
            return left - right;
        }
        else if (opr == '*') {
            return left * right;
        }
        else {
            throw new RuntimeException();
        }
    }
}

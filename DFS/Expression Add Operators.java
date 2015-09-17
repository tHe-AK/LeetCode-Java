public class Solution {
    public List<String> addOperators(String num, int target) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        helper(num, target, 0, 0, 0, "", result);
        
        return result;
    }
    
    private void helper(String num, int target, int start, int val, int pre, String str, List<String> result) {
        if (start == num.length()) {
            if (val == target) {
                result.add(str);
                return;
            }
        }
        
        for (int end = start + 1; end <= num.length(); end++) {
            if (end - start > 1 && num.charAt(start) == '0') {
                break;
            }
            
            long temp = Long.parseLong(num.substring(start, end));
            
            if (temp > Integer.MAX_VALUE || -temp < Integer.MIN_VALUE) {
                continue;
            }
            
            int cur = (int) temp;
            
            if (start == 0) {
                helper(num, target, end, val + cur, cur, str + cur, result);
            } else {
                helper(num, target, end, val + cur, cur, str + "+" + cur, result);
                helper(num, target, end, val - cur, -cur, str + "-" + cur, result);
                helper(num, target, end, val - pre + pre * cur, pre * cur, str + "*" + cur, result);
            }
        }
    }
}

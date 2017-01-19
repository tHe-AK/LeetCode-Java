public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        
        for (int i = 1; i <= 3 && i < len - 2; i++) {
            for (int j = i + 1; j <= i + 3 && j < len - 1; j++) {
                for (int k = j + 1; k <= j + 3 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String str) {
        if (str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
            return false;
        }
        
        return true;
    }
}

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        helper(s, 4, 0, "", result);
        
        return result;
    }
    
    private void helper(String s, int count, int start, String curr, List<String> result) {
        if (s.length() - start < count || s.length() - start > count * 3) {
            return;
        }
        
        if (count == 0) {
            result.add(curr);
            return;
        }
        
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String str = s.substring(start, i + 1);

            if ((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
                break;
            }

            helper(s, count - 1, i + 1, curr + (curr.length() == 0 ? "" : ".") + str, result);
        }
    }
}

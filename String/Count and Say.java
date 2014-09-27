public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 1;
            int count = 1;
            
            while (j < result.length()) {
                if (result.charAt(j - 1) == result.charAt(j)) {
                    count++;
                }
                else {
                    next.append(count);
                    next.append(result.charAt(j - 1));
                    count = 1;
                }
                
                j++;
            }
            
            next.append(count);
            next.append(result.charAt(j - 1));
            result = next.toString();
        }
        
        return result;
    }
}
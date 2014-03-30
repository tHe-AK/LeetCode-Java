public class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        
        StringBuilder result = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder("");
            char letter = result.charAt(0);
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == letter) {
                    count++;
                }
                else {
                    next.append(count);
                    next.append(letter);
                    letter = result.charAt(j);
                    count = 1;
                }
            }
            next.append(count);
            next.append(letter);
            result = next;
        }
        
        return result.toString();
    }
}

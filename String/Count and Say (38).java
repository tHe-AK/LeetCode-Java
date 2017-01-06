public class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char say = curr.charAt(0);
            
            for (int j = 1; j < curr.length(); j++) {
                if (curr.charAt(j) != curr.charAt(j - 1)) {
                    next.append(count).append(say);
                    count = 1;
                    say = curr.charAt(j);
                }
                else {
                    count++;
                }
            }
            
            next.append(count).append(say);
            curr = next;
        }
        
        return curr.toString();
    }
}

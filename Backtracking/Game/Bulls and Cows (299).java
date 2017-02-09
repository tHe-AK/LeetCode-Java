public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] rec = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            int digit1 = secret.charAt(i) - '0';
            int digit2 = guess.charAt(i) - '0';
            
            if (digit1 == digit2) {
                bull++;
            } else {
                if (rec[digit1]++ < 0) {
                    cow++;
                }
                
                if (rec[digit2]-- > 0) {
                    cow++;
                }
            }
        }
        
        return bull + "A" + cow + "B";
    }
}

public class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[10];
        int bull = 0;
        int cow = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            
            if (s == g) {
                bull++;
            } else {
                if (rec[s] < 0) {
                    cow++;
                }
                
                if (rec[g] > 0) {
                    cow++;
                }
                
                rec[s]++;
                rec[g]--;
            }
        }
        
        return bull + "A" + cow + "B";
    }
}

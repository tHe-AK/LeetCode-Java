public class Solution {
    public boolean checkRecord(String s) {
        int len = s.length();
        int countA = 0;
        
        for (int i = 0; i < len && countA < 2; i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            }
            
            if (i - 2 >= 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false;
            }
        }
        
        return countA < 2;
    }
}

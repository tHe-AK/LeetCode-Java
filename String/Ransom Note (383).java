public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rec = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            rec[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (rec[ransomNote.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        
        return true;
    }
}

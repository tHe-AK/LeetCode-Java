public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null) {
            return B == null;
        }
        
        if (A.length() < B.length()) {
            return false;
        }
        
        int[] rec = new int[26];
        
        for (int i = 0; i < A.length(); i++) {
            rec[A.charAt(i) - 'A']++;
        }
        
        for (int j = 0; j < B.length(); j++) {
            int index = B.charAt(j) - 'A';
            
            if (rec[index] == 0) {
                return false;
            }
            else {
                rec[index]--;
            }
        }
        
        return true;
    }
}

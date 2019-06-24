class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        
        int i = 0;
        int j = S.length() - 1;
        
        while (i < j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) {
                i++;
            }
            
            while (i < j && !Character.isLetter(sb.charAt(j))) {
                j--;
            }
            
            sb.setCharAt(i, S.charAt(j));
            sb.setCharAt(j, S.charAt(i));
            i++;
            j--;
        }
        
        return sb.toString();
    }
}

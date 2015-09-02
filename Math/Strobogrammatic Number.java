public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = num.length() - 1;
        String str = "00 11 696 88";
        
        while (i <= j) {
            if (str.indexOf(num.charAt(i) + "" + num.charAt(j)) == -1) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}

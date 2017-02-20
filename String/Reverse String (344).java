public class Solution {
    public String reverseString(String s) {
        char[] rec = s.toCharArray();
        int i = 0;
        int j = rec.length - 1;
        
        while (i < j) {
            char temp = rec[i];
            rec[i++] = rec[j];
            rec[j--] = temp;
        }
        
        return new String(rec);
    }
}

public class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int len = str.length;
        int i = 0;
        
        while (i < len) {
            int j = Math.min(i + k - 1, len - 1);
            reverse(str, i, j);
            i += 2 * k;
        }
        
        return String.valueOf(str);
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}

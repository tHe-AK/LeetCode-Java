public class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < k) {
            throw new IllegalArgumentException();
        }
        
        int len = num.length();
        int end = len - k;
        char[] rec = new char[len];
        int top = -1;

        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            
            while (k > 0 && top >= 0 && rec[top] > c) {
                top--;
                k--;
            }
            
            rec[++top] = c;
        }
        
        int begin = 0;
        while (begin < end && rec[begin] == '0') {
            begin++;
        }
        
        return begin == end ? "0" : new String(rec, begin, end - begin);
    }
}

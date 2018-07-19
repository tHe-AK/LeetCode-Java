class Solution {
    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        char[] str = Integer.toString(N).toCharArray();
        int i = 0;
        
        while (i < str.length - 1 && str[i] <= str[i + 1]) {
            i++;
        }
        
        if (i == str.length - 1) {
            return N;
        }
        
        while (i > 0 && str[i - 1] == str[i]) {
            i--;
        }
        
        str[i] = (char) (str[i] - 1);
        i++;
        
        while (i < str.length) {
            str[i++] = '9';
        }
        
        return Integer.parseInt(String.valueOf(str));
    }
}

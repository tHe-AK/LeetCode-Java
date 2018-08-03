class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int idx = 0;
        int anchor = 0;
        
        for (int i = 1; i <= len; i++) {
            if (i == len || chars[i] != chars[anchor]) {
                chars[idx++] = chars[anchor];

                if (i - anchor > 1) {
                    String str = Integer.toString(i - anchor);
                    
                    for (int j = 0; j < str.length(); j++) {
                        chars[idx++] = str.charAt(j);
                    }
                }
                
                anchor = i;
            }
        }
        
        return idx;
    }
}

class Solution {
    public String boldWords(String[] words, String s) {
        int len = s.length();
        
        boolean[] bold = new boolean[len];
        
        for (String word : words) {
            int size = word.length();
                
            if (size > 0) {
                for (int i = 0; i < len - size + 1; i++) {
                    if (s.startsWith(word, i)) {
                        for (int j = i; j < i + size; j++) {
                            bold[j] = true;
                        }
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < len) {
            if (bold[i]) {
                sb.append("<b>");
                
                while (i < len && bold[i]) {
                    sb.append(s.charAt(i++));
                }
                
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i++));
            }
        }
        
        return sb.toString();
    }
}

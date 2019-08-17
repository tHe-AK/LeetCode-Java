public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int count = 1;
        int len = words[0].length();
        int i = 1;
        
        while (i < words.length) {
            int wordLen = words[i].length();
            
            if (len + wordLen + count > maxWidth) {
                res.add(printLine(words, maxWidth, i, count, len));
                count = 1;
                len = wordLen;
            } else {
                count++;
                len += wordLen;
            }
            
            i++;
        }
        
        res.add(printLine(words, maxWidth, i, count, len));
        return res;
    }
    
    private String printLine(String[] words, int maxWidth, int i, int count, int len) {
        StringBuilder sb = new StringBuilder();
        int space = 1;
        int extra = 0;
        
        if (i != words.length && count != 1) {
            space = (maxWidth - len) / (count - 1);
            extra = (maxWidth - len) % (count - 1);
        }
        
        for (int j = i - count; j < i; j++) {
            sb.append(words[j]);
            
            if (j < i - 1) {
                appendSpace(sb, space);
                
                if (extra > 0) {
                    appendSpace(sb, 1);
                    extra--;
                }
             }
        }
        
        if (sb.length() < maxWidth) {
            appendSpace(sb, maxWidth - sb.length());
        }
        
        return sb.toString();
    }
    
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}

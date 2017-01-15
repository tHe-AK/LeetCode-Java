public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        int i = 0;
        
        while (i < len) {
            int wordLen = words[i].length();
            int spaceLen = 0;
            int j = i + 1;
            
            while (j < len && wordLen + spaceLen + 1 + words[j].length() <= maxWidth) {
                wordLen += words[j].length();
                spaceLen += 1;
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            if (spaceLen == 0 || j == len) {
                for (int k = i; k < j; k++) {
                    if (k > i) {
                        sb.append(" ");
                    }
                    
                    sb.append(words[k]);
                }
                
                appendSpace(sb, maxWidth - wordLen - spaceLen);
            } else {
                int spaceCount = (maxWidth - wordLen) / spaceLen;
                int extraCount = (maxWidth - wordLen) % spaceLen;
                
                for (int k = i; k < j; k++) {
                    if (k > i) {
                        appendSpace(sb, spaceCount);
                        
                        if (extraCount > 0) {
                            sb.append(" ");
                            extraCount--;
                        }
                    }
                    
                    sb.append(words[k]);
                }
            }
            
            result.add(sb.toString());
            i = j;
        }
        
        return result;
    }
    
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}

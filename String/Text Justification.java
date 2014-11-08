public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        if (words.length == 0) {
            return result;
        }
        
        int wc = 1;
        int cc = words[0].length();
        
        for (int i = 0; i < words.length; i++) {
            if (i + 1 < words.length || cc + wc + words[i + 1].length() > L) {
                String row = "";
                
                if (i == words.length - 1 || wc == 1) {
                    for (int j = i - wc + 1; j < i; j++) {
                        row += words[j] + " ";
                    }
                    
                    row += words[i];
                    row = addZero(row, L - cc - wc + 1);
                    
                    result.add(row);
                }
                else {
                    int sc = (L - cc) / (wc - 1);
                    int extra = (L - cc) % (wc - 1);

                    for (int j = i - wc + 1; j < i; j++) {
                        row += words[j];
                        
                        if (extra > 0) {
                            row = addZero(row, sc + 1); 
                            extra--;
                        }
                        else {
                            row = addZero(row, sc);
                        }
                    }
                    
                    row += words[i];
                    result.add(row);
                }
                
                if (i + 1 < words.length) {
                    wc = 1;
                    cc = words[i + 1].length();
                }
            }
            else {
                wc++;
                cc += words[i + 1].length();
            }
        }
        
        return result;
    }
    
    private String addZero(String str, int count) {
        for (int i = 0; i < count; i++) {
            str += " ";
        }
        
        return str;
    }
}
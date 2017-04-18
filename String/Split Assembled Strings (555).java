public class Solution {
    public String splitLoopedString(String[] strs) {
        int len = strs.length;
        String res = "";

        for (int i = 0; i < len; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        
        
        for (int i = 0; i < len; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            String[] list = { strs[i], rev };
            
            for (String str : list) {
                for (int k = 0; k < str.length(); k++) {
                    StringBuilder sb = new StringBuilder(str.substring(k));
                    
                    for (int j = i + 1; j < len; j++) {
                        sb.append(strs[j]);
                    }
                    
                    for (int j = 0; j < i; j++) {
                        sb.append(strs[j]);
                    }
                    
                    sb.append(str.substring(0, k));
                    
                    if (sb.toString().compareTo(res) > 0) {
                        res = sb.toString();
                    }
                }
            }
        }
        
        return res;
    }
}

public class Solution {
    public String alienOrder(String[] words) {
        List<Integer>[] rec = new List[26];
        String prev = null;
        
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            
            for (int j = 0; j < curr.length(); j++) {
                int idx = curr.charAt(j) - 'a';
                
                if (rec[idx] == null) {
                    rec[idx] = new ArrayList<>();
                }
            }

            if (prev != null) {
                int len1 = prev.length();
                int len2 = curr.length();
                int j = 0;
                
                while (j < len1 && j < len2) {
                    int idx1 = prev.charAt(j) - 'a';
                    int idx2 = curr.charAt(j) - 'a';
                    
                    if (idx1 != idx2) {
                        rec[idx1].add(idx2);
                        break;
                    }
                    
                    j++;
                }
                
                if ((j == len1 || j == len2) && len1 > len2) {
                    return "";
                }
            }
            
            prev = curr;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (rec[i] == null || !dfs(rec, i, new boolean[26], sb)) {
                return "";
            }
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    private boolean dfs(List<Integer>[] rec, int i, boolean[] visited, StringBuilder sb) {
        if (visited[i]) {
            return false;
        }
        
        String ch = Character.toString((char) ('a' + i));
        
        if (sb.indexOf(ch) != -1) {
            return true;
        }
 
        visited[i] = true;
        
        for (Integer j : rec[i]) {
            if (!dfs(rec, j, visited, sb)) {
                return false;
            }
        }
        
        visited[i] = false;
        sb.append(ch);
        
        return true;
    }
}

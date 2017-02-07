public class Solution {
    public String alienOrder(String[] words) {
        List<List<Integer>> rec = new ArrayList<>();
        boolean[] visited = new boolean[26];
        String prev = null;
        
        for (int i = 0; i < 26; i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            
            for (int j = 0; j < curr.length(); j++) {
                visited[curr.charAt(j) - 'a'] = true;
            }

            if (prev != null) {
                int len1 = prev.length();
                int len2 = curr.length();
                int j = 0;
                
                while (j < len1 && j < len2) {
                    int ch1 = prev.charAt(j) - 'a';
                    int ch2 = curr.charAt(j) - 'a';
                    
                    if (ch1 != ch2) {
                        rec.get(ch1).add(ch2);
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
            if (visited[i] && !dfs(rec, i, new boolean[26], sb)) {
                return "";
            }
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    private boolean dfs(List<List<Integer>> rec, int i, boolean[] visited, StringBuilder sb) {
        if (visited[i]) {
            return false;
        }
        
        char ch = (char) ('a' + i);
        
        if (sb.indexOf(Character.toString(ch)) != -1) {
            return true;
        }
 
        visited[i] = true;
        
        for (Integer j : rec.get(i)) {
            if (!dfs(rec, j, visited, sb)) {
                return false;
            }
        }
        
        visited[i] = false;
        sb.append(ch);
        
        return true;
    }
}

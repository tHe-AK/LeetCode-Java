class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int size = queue.size();
            
            for (int j = 0; j < size; j++) {
                String peek = queue.poll();
                
                if (Character.isLetter(ch)) {
                    queue.offer(peek + Character.toLowerCase(ch));
                    queue.offer(peek + Character.toUpperCase(ch));
                } else {
                    queue.offer(peek + ch);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, 0, "", res);
        return res;
    }
    
    private void dfs(String S, int i, String str, List<String> res) {
        if (i == S.length()) {
            res.add(str);
            return;
        }
        
        char ch = S.charAt(i);
        
        if (Character.isLetter(ch)) {
            dfs(S, i + 1, str + Character.toLowerCase(ch), res);
            dfs(S, i + 1, str + Character.toUpperCase(ch), res);
        } else {
            dfs(S, i + 1, str + ch, res);
        }
    }
}

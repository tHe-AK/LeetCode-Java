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

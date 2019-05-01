class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' }));
        StringBuilder sb = new StringBuilder();
        String[] words = S.split("\\s");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (i > 0) {
                sb.append(" ");
            }
            
            if (set.contains(word.charAt(0))) {
                sb.append(word.substring(0));
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            
            sb.append("ma");
                    
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
        }
        
        return sb.toString();
    }
}

class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String str = "";
        
        for (String word : words) {
            set.add(word);
        }
        
        for (String word : words) {
            int len = word.length();
            int end = len;
            
            while (end > 0 && set.contains(word.substring(0, end))) {
                end--;
            }
            
            if (end == 0 && (str.isEmpty() || str.length() < len || (str.length() == len && word.compareTo(str) < 0))) {
                str = word;
            } 
        }
            
        return str;
    }
}

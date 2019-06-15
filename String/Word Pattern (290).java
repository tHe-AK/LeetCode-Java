public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int len = words.length;
        
        if (pattern.length() != len) {
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (Integer i = 0; i < len; i++) {
            if (map1.put(pattern.charAt(i), i) != map2.put(words[i], i)) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int len = words.length;
        
        if (pattern.length() != len) {
            return false;
        }
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            map1.putIfAbsent(ch, word);
            map2.putIfAbsent(word, ch);
            
            if (!map1.get(ch).equals(word) || map2.get(word) != ch) {
                return false;
            }
        }
        
        return true;
    }
}

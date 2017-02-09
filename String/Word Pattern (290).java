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

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int len = words.length;
        
        if (pattern.length() != len) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(ch)) {
                if (map.get(ch).equals(word)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (set.contains(word)) {
                    return false;
                }
                
                map.put(ch, word);
                set.add(word);
            }
        }
        
        return true;
    }
}

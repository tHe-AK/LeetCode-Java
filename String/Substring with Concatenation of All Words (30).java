public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        int total = len * words.length;
        
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        
        for (int i = 0; i < s.length() - total + 1; i++) {
            Map<String, Integer> copy = new HashMap<>(map);

            for (int j = i; j < i + total; j += len) {
                String str = s.substring(j, j + len);
                
                if (copy.containsKey(str)) {
                    if (copy.get(str) == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, copy.get(str) - 1);
                    }
                    
                    if (copy.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}

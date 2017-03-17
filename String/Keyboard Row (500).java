public class Solution {
    public String[] findWords(String[] words) {
        String[] strs = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i< strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                map.put(strs[i].charAt(j), i);
            }
        }
        
        for (String word : words) {
            int len = word.length();
            
            if (len > 0) {
                int row = map.get(word.toUpperCase().charAt(0));
                int i = 1;
                
                while (i < len && map.get(word.toUpperCase().charAt(i)) == row) {
                    i++;
                }
                
                if (i == len) {
                    result.add(word);
                }
            }
        }
        
        return result.toArray(new String[0]);
    }
}

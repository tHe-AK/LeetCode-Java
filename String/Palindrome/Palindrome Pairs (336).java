public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>(); 
        
        if (words.length < 2) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        int len = words.length;
        
        for (int i = 0; i < len; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if (isPalindrome(str1)) {
                    String reversed = new StringBuilder(str2).reverse().toString();
                    
                    if (map.containsKey(reversed) && map.get(reversed) != i) {
                        Integer[] pair = { map.get(reversed), i };
                        result.add(Arrays.asList(pair));
                    }
                }
                
                if (str2.length() > 0 && isPalindrome(str2)) {
                    String reversed = new StringBuilder(str1).reverse().toString();

                    if (map.containsKey(reversed) && map.get(reversed) != i) { 
                        Integer[] pair = { i, map.get(reversed) };
                        result.add(Arrays.asList(pair));
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
}

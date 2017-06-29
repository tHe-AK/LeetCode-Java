public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> rec = new HashMap<>();
        
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            rec.putIfAbsent(key, new ArrayList<String>());
            rec.get(key).add(str);
        }
        
        return new ArrayList<>(rec.values());
    }
}

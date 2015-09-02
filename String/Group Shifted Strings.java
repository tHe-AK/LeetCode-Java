public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> rec = new HashMap<String, List<String>>();
        
        for (String str : strings) {
            int offset = 0;
            String key = "";
            
            for (int i = 0; i < str.length(); i++) {
                if (i == 0) {
                    offset = str.charAt(0) - 'a';
                }
                
                char cur = (char) (str.charAt(i) - offset);
                
                if (cur < 'a') {
                    cur += 26;
                }
                
                key += cur;
            }
            
            if (!rec.containsKey(key)) {
                rec.put(key, new ArrayList<String>());
            }
            
            rec.get(key).add(str);
        }
        
        for (String key : rec.keySet()) {
            List<String> value = rec.get(key);
            Collections.sort(value);
            result.add(value);
        }
        
        return result;
    }
}

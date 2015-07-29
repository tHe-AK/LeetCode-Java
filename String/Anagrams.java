public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        
        if (strs == null) {
            return result;
        }
        
        HashMap<String, List<String>> rec = new HashMap<String, List<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            String key = null;
            
            if (strs[i] != null) {
                char[] temp = strs[i].toCharArray();
                Arrays.sort(temp);
                key = new String(temp);
            }
            
            if (rec.containsKey(key)) {
                rec.get(key).add(strs[i]);
            }
            else {
                ArrayList<String> val = new ArrayList<String>();
                val.add(strs[i]);
                rec.put(key, val);
            }
        }
        
        for (String key : rec.keySet()) {
            if (rec.get(key).size() > 1) {
                for (String str : rec.get(key)) {
                    result.add(str);
                }
            }
        }
        
        return result;
    }
}

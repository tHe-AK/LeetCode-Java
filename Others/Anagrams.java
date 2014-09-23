public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<String>();
        }
        
        HashMap<String, ArrayList<String>> rec = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if (rec.containsKey(key) == true) {
                rec.get(key).add(strs[i]);
            }
            else {
                ArrayList<String> value = new ArrayList<String>();
                value.add(strs[i]);
                rec.put(key, value);
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();
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

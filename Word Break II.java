public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return new ArrayList<String>();
        }
        
        int len = s.length();
        ArrayList<ArrayList<String>> rec = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < len; i++) {
            rec.add(new ArrayList<String>());
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String str = s.substring(i, j + 1);
                if (dict.contains(str)) {
                    rec.get(j).add(str);
                }
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();
        helper(len - 1, "", rec, result);
        
        return result;
    }
    
    private void helper(int index, String cur, ArrayList<ArrayList<String>> rec, ArrayList<String> result) {
        if (index == -1) {
            result.add(cur.trim());
            return;
        }
        
        for (String str : rec.get(index)) {
            helper(index - str.length(), str + " " + cur, rec, result);
        }
    }
}

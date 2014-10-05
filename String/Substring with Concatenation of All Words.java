public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        if (S == null || L == null || L.length == 0 || L[0].length() == 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> rec = new HashMap<String, Integer>();
        int len = L[0].length();
        int count = len * L.length;
        
        for (int i = 0; i < L.length; i++) {
            if (rec.containsKey(L[i])) {
                rec.put(L[i], rec.get(L[i]) + 1);
            }
            else {
                rec.put(L[i], 1);
            }
        }
        
        for (int i = 0; i < S.length() - count + 1; i++) {
            HashMap<String, Integer> cur = new HashMap<String, Integer>(rec);
            int j;
            
            for (j = i; j < i + count; j += len) {
                String str = S.substring(j, j + len);
                
                if (cur.containsKey(str)) {
                    if (cur.get(str) == 1) {
                        cur.remove(str);
                    }
                    else {
                        cur.put(str, cur.get(str) - 1);
                    }                
                }
                else {
                    break;
                }
            }
            
            if (j == i + count) {
                result.add(i);
            }
        }
        
        return result;
    }
}
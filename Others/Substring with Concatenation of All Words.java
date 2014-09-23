public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        if (S == null || L.length == 0 || L[0].length() == 0 || S.length() < L.length * L[0].length()) {
            return new ArrayList<Integer>();
        }
        
        HashMap<String, Integer> rec = new HashMap<String, Integer>();
        int sum = 0;
        for (String str : L) {
            sum++;
            if (rec.containsKey(str) == true) {
                rec.put(str, rec.get(str) + 1);
            }
            else {
                rec.put(str, 1);
            }
        }
        int len = L[0].length();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i <= S.length() - L.length * len; i++) {
            HashMap<String, Integer> cur = new HashMap<String, Integer>(rec);
            int count = 0;
            int j = i;
            while (j <= S.length() - len) {
                String str = S.substring(j, j + len);
                if (cur.containsKey(str) && cur.get(str) > 0) {
                    cur.put(str, cur.get(str) - 1);
                    count++;
                    j += len;
                }
                else {
                    break;
                }
            }
            if (count == sum) {
                result.add(i);
            }
        }
        
        return result;
    }
}

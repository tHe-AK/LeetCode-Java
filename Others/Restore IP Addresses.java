public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12 || s.length() < 4) {
            return new ArrayList<String>();
        }
        
        ArrayList<String> result = new ArrayList<String>();
        helper(0, new ArrayList<String>(), s, result);
        
        return result;
    }
    
    private void helper(int index, ArrayList<String> cur, String s, ArrayList<String> result) {
        if (s.length() - index > (4 - cur.size()) * 3 || s.length() - index < 4 - cur.size()) {
            return;
        }
        
        if (cur.size() == 4) {
            result.add(cur.get(0) + "." + cur.get(1) + "." + cur.get(2) + "." + cur.get(3));
            return;
        }
        
        for (int i = index; i < s.length() && i < index + 3; i++) {
            String temp = s.substring(index, i + 1);
            if ((temp.length() == 2 && temp.charAt(0) == '0') || (temp.length() == 3 && Integer.valueOf(temp) > 255)) {
                break;
            }
            cur.add(temp);
            helper(i + 1, cur, s, result);
            cur.remove(cur.size() - 1);
        }
    }
}

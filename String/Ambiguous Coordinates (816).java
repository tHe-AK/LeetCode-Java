class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        
        for (int i = 2; i < S.length() - 1; i++) {
            List<String> left = helper(S.substring(1, i));
            List<String> right = helper(S.substring(i, S.length() - 1));
            
            if (!left.isEmpty() && !right.isEmpty()) {
                for (String str1 : left) {
                    for (String str2 : right) {
                        res.add("(" + str1 + ", " + str2 + ")");
                    }
                }
            }
        }
        
        return res;
    }
    
    private List<String> helper(String str) {
        List<String> strs = new ArrayList<>();
        
        if (str.equals("0")) {
            strs.add(str);
        } else if (str.startsWith("0") && str.endsWith("0")) {
            return strs;
        } else if (str.startsWith("0")) {
            strs.add("0." + str.substring(1));
        } else if (str.endsWith("0")) {
            strs.add(str);
        } else {
            strs.add(str);
            
            for (int i = 1; i < str.length(); i++) {
                strs.add(str.substring(0, i) + "." + str.substring(i));
            }
        }
        
        return strs;
    }
}

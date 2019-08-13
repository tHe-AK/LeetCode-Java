class Solution {
    public String[] expand(String S) {
        if (S.isEmpty()) {
            return new String[] { "" };
        } else if (S.charAt(0) != '{') {
            char ch = S.charAt(0);
            String[] strs = expand(S.substring(1));
            
            for (int i = 0; i < strs.length; i++) {
                strs[i] = ch + strs[i];
            }
            
            return strs;
        } else {
            int i = 1;
            
            while (i < S.length() && S.charAt(i) != '}') {
                i++;
            }
            
            String[] options = S.substring(1, i).split(",");
            String[] strs = expand(S.substring(i + 1));
            Set<String> set = new TreeSet<>();
            
            for (String str : strs) {
                for (String option : options) {
                    set.add(option + str);
                }
            }
            
            return set.toArray(new String[0]);
        }
    }
}

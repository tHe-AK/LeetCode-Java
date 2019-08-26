class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> res = new TreeSet<>();
        Set<String> set = new HashSet<>();
        set.add("");
        int i = 0;
        
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            
            if (ch == '{') {
                int count = 1;
                int start = ++i;
                
                while (count > 0) {
                    if (expression.charAt(i) == '{') {
                        count++;
                    } else if (expression.charAt(i) == '}') {
                        count--;
                    }
                    
                    i++;
                }
                
                List<String> strs = braceExpansionII(expression.substring(start, i - 1));
                set = mergeAll(set, strs);
            } else if (ch == ',') {
                res.addAll(set);
                set.clear();
                set.add("");
                i++;
            } else {
                set = merge(set, String.valueOf(ch));
                i++;
            }
        }
        
        res.addAll(set);
        return new ArrayList<>(res);
    }
    
    private Set<String> merge(Set<String> set, String str) {
        Set<String> res = new HashSet<>();
        
        for (String s : set) {
            res.add(s + str);
        }
        
        return res;
    }
    
    private Set<String> mergeAll(Set<String> set, List<String> strs) {
        Set<String> res = new HashSet<>();
        
        for (String str : strs) {
            res.addAll(merge(set, str));
        }
        
        return res;
    }
}

class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder res = new StringBuilder();
        Map<String, Integer> map = parse(formula);
        
        for (String key : map.keySet()) {
            res.append(key);
            int count = map.get(key);
            
            if (count > 1) {
                res.append(count);
            }
        }
        
        return res.toString();
    }
    
    private Map<String, Integer> parse(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        int len = formula.length();
        int i = 0;
        
        while (i < len) {            
            if (Character.isLetter(formula.charAt(i))) {
                StringBuilder str = new StringBuilder();
                str.append(formula.charAt(i++));

                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    str.append(formula.charAt(i++));
                }
                
                int count = getCount(formula, i);
                
                if (count > 1) {
                    i += Integer.toString(count).length();
                }
                
                updateMap(map, str.toString(), count);
            } else {
                int left = 1;
                int start = ++i;
                
                while (i < len) {
                    char ch = formula.charAt(i++);
                    
                    if (ch == '(') {
                        left++;
                    } else if (ch == ')') {
                        left--;
                    }
                    
                    if (left == 0) {
                        Map<String, Integer> curr = parse(formula.substring(start, i - 1));
                        int count = getCount(formula, i);
                
                        if (count > 1) {
                            i += Integer.toString(count).length();
                        }
                        
                        for (String key : curr.keySet()) {
                            updateMap(map, key, curr.get(key) * count);
                        }
                        
                        break;
                    }
                }
            }
        }
        
        return map;
    }
    
    private int getCount(String formula, int i) {
        if (i < formula.length() && Character.isDigit(formula.charAt(i))) {
            int count = 0;
            
            while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                count = count * 10 + formula.charAt(i++) - '0';
            }
            
            return count;
        } else {
            return 1;
        }
    }
    
    private void updateMap(Map<String, Integer> map, String str, int count) {
        map.putIfAbsent(str, 0);
        map.put(str, map.get(str) + count);
    }
}

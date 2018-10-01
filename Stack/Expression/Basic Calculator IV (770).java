class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        
        Map<List<String>, Integer> res = calculate(expression, map);
        List<List<String>> list = new ArrayList<>(res.keySet());
        Collections.sort(list, (a, b) -> {
            if (a.size() != b.size()) {
                return Integer.compare(b.size(), a.size());
            } else {
                for (int i = 0; i < a.size(); i++) {
                    String str1 = a.get(i);
                    String str2 = b.get(i);
                    
                    if (!str1.equals(str2)) {
                        return str1.compareTo(str2);
                    }
                }
                
                return 0;
            }
        });
        
        List<String> strs = new ArrayList<>();
        
        for (List<String> key : list) {
            int val = res.get(key);
            
            if (val != 0) {
                String str = val + (key.isEmpty() ? "" : "*" + String.join("*", key));
                strs.add(str);
            }
        }
        
        return strs;
    }
    
    private Map<List<String>, Integer> calculate(String expression, Map<String, Integer> map) {
        Stack<Map<List<String>, Integer>> stack = new Stack<>();
        char sign = '+';
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == '(' || Character.isLetterOrDigit(ch)) {
                Map<List<String>, Integer> val = new HashMap<>();

                if (ch == '(') {
                    int start = ++i;
                    int count = 1;

                    while (count > 0) {
                        char curr = expression.charAt(i++);

                        if (curr == '(') {
                            count++;
                        } else if (curr == ')') {
                            count--;
                        }
                    }

                    String str = expression.substring(start, i);
                    val = calculate(str, map);
                } else if (Character.isDigit(ch)) {
                    int num = 0;
                
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        num = num * 10 + expression.charAt(i++) - '0';
                    }
                    
                    val.put(new ArrayList<>(), num);
                } else {
                    int start = i++;
                    
                    while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                        i++;
                    }
                    
                    String str = expression.substring(start, i);
                    
                    if (map.containsKey(str)) {
                        val.put(new ArrayList<>(), map.get(str));
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(str);
                        val.put(list, 1);
                    }
                }
                
                if (sign == '+') {
                    stack.push(val);
                } else if (sign == '-') {
                    Map<List<String>, Integer> temp = new HashMap<>();
                    
                    for (List<String> key : val.keySet()) {
                        temp.put(key, -val.get(key));
                    }
                    
                    stack.push(temp);
                } else {
                    Map<List<String>, Integer> peek = stack.pop();
                    Map<List<String>, Integer> temp = new HashMap<>();
                    
                    for (List<String> key1 : peek.keySet()) {
                        for (List<String> key2 : val.keySet()) {
                            List<String> key = new ArrayList<>(key1);
                            key.addAll(key2);
                            Collections.sort(key);
                            temp.put(key, temp.getOrDefault(key, 0) + peek.get(key1) * val.get(key2));
                        }
                    }
                    
                    stack.push(temp);
                }
            } else if (ch != ' ') {
                sign = ch;
            }
        }
        
        Map<List<String>, Integer> res = new HashMap<>();
        
        for (Map<List<String>, Integer> val : stack) {
            for (List<String> key : val.keySet()) {
                res.put(key, res.getOrDefault(key, 0) + val.get(key));
            }
        }
        
        return res;
    }
}

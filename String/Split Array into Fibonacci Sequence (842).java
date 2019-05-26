class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        int N = S.length();
        
        for (int i = 1; i < N - 1; i++) {
            long first = getNum(S.substring(0, i));
            
            if (first == -1) {
                break;
            }
            
            for (int j = i + 1; j < N; j++) {
                long second = getNum(S.substring(i, j));
            
                if (second == -1) {
                    break;
                }
                
                List<Integer> res = new ArrayList<>();
                res.add((int) first);
                res.add((int) second);
                int k = j;
                
                while (k < N) {
                    long third = 0L + res.get(res.size() - 1) + res.get(res.size() - 2);
                    
                    if (third > Integer.MAX_VALUE) {
                        break;
                    }
                    
                    String str = String.valueOf(third);
                    
                    if (!S.startsWith(str, k)) {
                        break;
                    }
                        
                    res.add((int) third);
                    k += str.length();
                }
                        
                if (k == N) {
                    return res;
                }
            }
        }
        
        return new ArrayList<>();
    }
    
    private long getNum(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            return -1;
        }
            
        long first = Long.parseLong(str);
            
        if (first > Integer.MAX_VALUE) {
            return -1;
        }
        
        return first;
    }
}

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S, 0, res);
        return res;
    }
    
    private boolean dfs(String S, int i, List<Integer> res) {
        if (i == S.length()) {
            return res.size() > 2;
        }
        
        if (res.size() >= 2) {
            long num = 0L + res.get(res.size() - 1) + res.get(res.size() - 2);
                    
            if (num > Integer.MAX_VALUE) {
                return false;
            }
                    
            String str = String.valueOf(num);
                    
            if (!S.startsWith(str, i)) {
                return false;
            }
            
            res.add((int) num);
            
            if (dfs(S, i + str.length(), res)) {
                return true;
            }
            
            res.remove(res.size() - 1);
        } else {
            for (int j = i + 1; j <= S.length(); j++) {
                if (j > i + 1 && S.charAt(i) == '0') {
                    return false;
                }

                long num = Long.parseLong(S.substring(i, j));

                if (num > Integer.MAX_VALUE) {
                    return false;
                }
                
                res.add((int) num);
            
                if (dfs(S, j, res)) {
                    return true;
                }

                res.remove(res.size() - 1);
            }
        }
        
        return false;
    }
}

class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int res = 0;
        
        while (end < S.length()) {
            char ch = S.charAt(end++);
            
            while (set.contains(ch)) {
                set.remove(S.charAt(start++));
            }
            
            set.add(ch);
            res += end - start >= K ? 1 : 0;
        }
        
        return res;
    }
}

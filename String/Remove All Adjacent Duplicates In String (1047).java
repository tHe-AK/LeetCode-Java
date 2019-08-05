class Solution {
    public String removeDuplicates(String S) {
        int N = S.length();
        char[] stack = new char[N];
        int idx = 0;
        
        for (char ch : S.toCharArray()) {
            if (idx > 0 && stack[idx - 1] == ch) {
                idx--;
            } else {
                stack[idx++] = ch;
            }
        }
        
        return new String(stack, 0, idx);
    }
}

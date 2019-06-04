class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            
            for (char ch : A.toCharArray()) {
                set.add(ch);
            }
            
            return set.size() < A.length();
        }
            
        int idx = -1;
        int count = 0;
                                               
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    idx = i;
                    count++;
                } else if (count == 1 && A.charAt(i) == B.charAt(idx) && B.charAt(i) == A.charAt(idx)) {
                    count++;
                } else {
                    return false;
                }
            }
        }
                                               
        return true;
    }
}

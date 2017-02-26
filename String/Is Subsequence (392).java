public class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] rec = new List[26];
        
        for (int i = 0; i < 26; i++) {
            rec[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < t.length(); i++) {
            rec[t.charAt(i) - 'a'].add(i);
        }
        
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int pos = Collections.binarySearch(rec[ch], idx);
            
            if (pos < 0) {
                pos = -pos - 1;
            }
            
            if (pos == rec[ch].size()) {
                return false;
            }
            
            idx = rec[ch].get(pos) + 1;
        }
        
        return true;
    }
}

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return i == s.length();
    }
}

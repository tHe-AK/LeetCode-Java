public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        
        int N = 26;
        int[] map1 = new int[N];
        int[] map2 = new int[N];
        int count = 0;

        for (int i = 0; i < len1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < N; i++) {
            if (map1[i] == map2[i]) {
                count++;
            }
        }
        
        for (int i = 0; i < len2 - len1; i++) {
            if (count == N) {
                return true;
            }
            
            int right = s2.charAt(i + len1) - 'a';
            int left = s2.charAt(i) - 'a';
            
            map2[right]++;

            if (map2[right] == map1[right]) {
                count++;
            } else if (map2[right] == map1[right] + 1) {
                count--;
            }
            
            map2[left]--;
            
            if (map2[left] == map1[left]) {
                count++;
            } else if (map2[left] == map1[left] - 1) {
                count--;
            }
        }
        
        return count == N;
    }
}

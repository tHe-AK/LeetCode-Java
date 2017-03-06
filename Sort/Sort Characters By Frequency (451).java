public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int[] count = new int[256];
        List<Character>[] freq = new List[len + 1];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (freq[count[i]] == null) {
                    freq[count[i]] = new ArrayList<>();
                }
                
                freq[count[i]].add((char) i);
            }
        }
        
        for (int i = len; i > 0; i--) {
            if (freq[i] != null) {
                for (Character ch : freq[i]) {
                    for (int k = 0; k < i; k++) {
                        sb.append(ch);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}

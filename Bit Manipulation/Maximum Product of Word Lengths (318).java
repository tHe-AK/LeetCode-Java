public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}

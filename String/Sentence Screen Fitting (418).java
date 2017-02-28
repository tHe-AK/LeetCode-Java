public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence) + " ";
        int start = 0;
        int len = str.length();

        for (int i = 0; i < rows; i++) {
            start += cols;
            
            if (str.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && str.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        
        return start / len;
    }
}

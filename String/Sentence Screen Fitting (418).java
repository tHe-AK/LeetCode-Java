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

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = sentence.length;
        int count = 0;
        int idx = 0;
        
        for (int i = 0; i < rows; i++) {
            int size = cols;
            
            while (idx < len && sentence[idx].length() <= size) {
                size -= sentence[idx].length() + 1;

                if (++idx == len) {
                    count++;
                    idx = 0;
                }
            }    
        }
        
        return count;
    }
}

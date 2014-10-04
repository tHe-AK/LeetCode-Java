public class Solution {
    public void sortLetters(char[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < array.length; i++) {
            if ('a' <= array[i] && array[i] <= 'z') {
                char temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
                cur++;
            }
        }
    }
}

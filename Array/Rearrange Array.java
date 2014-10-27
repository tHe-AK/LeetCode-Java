public class Solution {
    public void rearrange(int[] input, int[] index) {
        if (input == null || index == null) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < input.length; i++) {
            while (index[i] != i) {
                int temp = input[i];
                int pos = index[i];
                
                input[i] = input[pos];
                input[pos] = temp;
                
                index[i] = index[pos];
                index[pos] = pos;
            }
        }
    }
}
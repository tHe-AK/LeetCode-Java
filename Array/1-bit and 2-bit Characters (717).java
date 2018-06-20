class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int len = bits.length;
        
        while (i < len - 1) {
            i += bits[i] + 1;
        }
        
        return i == len - 1;
    }
}

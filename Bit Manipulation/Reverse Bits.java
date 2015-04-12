public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int low = (n >> i) & 1;
            int high = (n >> (31 - i)) & 1;
            
            if ((low ^ high) == 1) {
                n ^= (1 << i) | (1 << (31 -i));
            }
        }
        
        return n;
    }
}
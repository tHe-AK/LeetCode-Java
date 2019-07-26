class Solution {
    public int bitwiseComplement(int N) {
        int i = 1;
        
        while (i < N) {
            i = (i << 1) + 1;
        }
        
        return i - N;
    }
}

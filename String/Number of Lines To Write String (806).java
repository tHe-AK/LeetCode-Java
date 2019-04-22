class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int row = 1;
        int idx = 0;
        
        for (char ch : S.toCharArray()) {
            int size = widths[ch - 'a'];
            
            if (idx + size > 100) {
                row++;
                idx = 0;
            }
            
            idx += size;
        }
        
        return new int[] { row, idx };
    }
}

public class Solution {
    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 11) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount((i << 6) + j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        
        return result;
    }
}

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int[] row : matrix) {
            String str1 = "";
            String str2 = "";
            
            for (int i : row) {
                if (i == 0) {
                    str1 += "1";
                    str2 += "0";
                } else {
                    str1 += "0";
                    str2 += "1";
                }
            }
            
            int val1 = map.getOrDefault(str1, 0) + 1;
            int val2 = map.getOrDefault(str2, 0) + 1;
            map.put(str1, val1);
            map.put(str2, val2);
            max = Math.max(max, Math.max(val1, val2));
        }
        
        return max;
    }
}

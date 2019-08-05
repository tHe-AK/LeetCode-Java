class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int res = 0;
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                res++;
            }
        }
        
        return res;
    }
}

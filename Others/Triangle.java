public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[triangle.size()];
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                rec[j] += triangle.get(i).get(j);
                
                if (j > 0) {
                    rec[j - 1] = Math.min(rec[j - 1], rec[j]);
                }
            }
        }
        
        return rec[0];
    }
}

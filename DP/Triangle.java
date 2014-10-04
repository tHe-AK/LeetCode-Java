public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = triangle.get(triangle.size() - 1);
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result.set(j, triangle.get(i).get(j) + Math.min(result.get(j), result.get(j + 1)));
            }
        }
        
        return result.get(0);
    }
}
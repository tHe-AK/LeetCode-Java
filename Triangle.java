public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int size = triangle.size();
        int[] cur = new int[triangle.get(size - 1).size()];
        
        for (int j = 0; j < triangle.get(size - 1).size(); j++) {
            cur[j] = triangle.get(size - 1).get(j);
        }
        
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                cur[j] = triangle.get(i).get(j) + Math.min(cur[j], cur[j + 1]);
            }
        }
        
        return cur[0];
    }
}

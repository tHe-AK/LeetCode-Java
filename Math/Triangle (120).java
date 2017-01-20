public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            List<Integer> pre = triangle.get(i + 1);
            
            for (int j = 0; j < curr.size(); j++) {
                curr.set(j, curr.get(j) + Math.min(pre.get(j), pre.get(j + 1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
}

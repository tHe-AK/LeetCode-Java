public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            for (int j = curr.size() - 1; j > 0; j--) {
                curr.set(j, curr.get(j) + curr.get(j - 1));
            }
            
            curr.add(1);
            result.add(new ArrayList<Integer>(curr));
        }
        
        return result;
    }
}

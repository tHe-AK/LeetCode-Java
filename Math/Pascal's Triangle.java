public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();

        for (int i = 1; i <= numRows; i++) {
            for (int j = cur.size() - 1; j > 0; j--) {
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
            
            cur.add(1);
            result.add(new ArrayList<Integer>(cur));
        }
        
        return result;
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        for (int i = 1; i <= numRows; i++) {
            for (int j = cur.size() - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);
            result.add(new ArrayList<Integer>(cur));
        }
        
        return result;
    }
}

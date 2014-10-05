public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> cur = new ArrayList<Integer>();

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = cur.size() - 1; j > 0; j--) {
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
            
            cur.add(1);
        }
        
        return cur;
    }
}
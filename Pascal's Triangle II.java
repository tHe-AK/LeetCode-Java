public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = result.size() - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }
        
        return result;
    }
}

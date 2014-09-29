public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < S.length; i++) {
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
                result.add(new ArrayList<Integer>(result.get(j)));
                result.get(result.size() - 1).add(S[i]);
            }
        }
        
        return result;
    }
}
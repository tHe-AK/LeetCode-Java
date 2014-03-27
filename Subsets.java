public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        result.add(cur);
        for (int i = 0; i < S.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(S[i]);
                result.add(temp);
            }
        }
        
        return result;
    }
}

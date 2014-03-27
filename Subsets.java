public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(new ArrayList<Integer>(), 0, S, result);
        
        return result;
    }
    
    private void helper(ArrayList<Integer> cur, int index, int[] S, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = index; i < S.length; i++) {
            cur.add(S[i]);
            helper(cur, i + 1, S, result);
            cur.remove(cur.size() - 1);
        }
    }
}

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

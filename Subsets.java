public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(S, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] S, int start, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < S.length; i++) {
            cur.add(S[i]);
            helper(S, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
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

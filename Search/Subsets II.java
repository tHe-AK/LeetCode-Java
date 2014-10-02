public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int sizePre = 0;
        
        for (int i = 0; i < num.length; i++) {
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
                if (i > 0 && num[i] == num[i - 1] && j < sizePre) {
                    continue;
                }
                
                List<Integer> cur = new ArrayList(result.get(j));
                cur.add(num[i]);
                result.add(cur);
            }
            
            sizePre = size;
        }
        
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(num, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, int start, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            
            cur.add(num[i]);
            helper(num, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
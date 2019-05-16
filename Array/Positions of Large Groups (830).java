class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        
        for (int i = 1; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) != S.charAt(start)) {
                if (i - start >= 3) {
                    res.add(Arrays.asList(new Integer[] { start, i - 1 }));
                }
                            
                start = i;
            }
        }
                            
        return res;
    }
}

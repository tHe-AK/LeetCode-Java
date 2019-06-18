class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            
            while (map.size() > 2) {
                if (map.put(tree[start], map.get(tree[start]) - 1) == 1) {
                    map.remove(tree[start]);
                }
                
                start++;
            }
            
            max = Math.max(max, i - start + 1);
        }
        
        return max;
    }
}

class Solution {
    private Map<Integer, Integer> map;
    private int count;
    private Random rand;
    
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        count = N - blacklist.length;
        N--;
        rand = new Random();
        
        for (int num : blacklist) {
            map.put(num, -1);
        }
                
        for (int num : blacklist) {
            if (num < count) {
                while (map.containsKey(N)) {
                    N--;
                }
                
                map.put(num, N);
                N--;
            }
        }
    }
    
    public int pick() {
        int num = rand.nextInt(count);
        return map.getOrDefault(num, num);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */

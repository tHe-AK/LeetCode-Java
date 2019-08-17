class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            min = Math.min(min, num);
            max = Math.max(max, num);
            pq.offer(new int[] { num, i, 0 });
        }
        
        int[] res = { min, max };
        
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            min = peek[0];
            int i = peek[1];
            int j = peek[2];
            int curr = max - min;
            int diff = res[1] - res[0];
            
            if (curr < diff || (curr == diff && min < res[0])) {
                res[0] = min;
                res[1] = max;
            }
            
            if (j + 1 == nums.get(i).size()) {
                break;
            } else {
                int next = nums.get(i).get(j + 1);
                max = Math.max(max, next);
                pq.offer(new int[] { next, i, j + 1 });
            }
        }
        
        return res;
    }
}

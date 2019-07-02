class Solution {
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        while (list.size() < N) {
            List<Integer> next = new ArrayList<>();
            
            for (int i : list) {
                if (i * 2 - 1 <= N) {
                    next.add(i * 2 - 1);
                }
            }
            
            for (int i : list) {
                if (i * 2 <= N) {
                    next.add(i * 2);
                }
            }
            
            list = next;
        }
        
        
        for (int i = 0; i < N; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}

class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        List<Integer> list = new ArrayList<>();
        
        while (target > 0) {
            list.add(target % x);
            target /= x;
        }
        
        int N = list.size();
        int pos = list.get(0) * 2;
        int neg = (x - list.get(0)) * 2;
        
        for (int i = 1; i < N; i++) {
            int num = list.get(i);
            int nextPos = Math.min(num * i + pos, (num + 1) * i + neg);
            int nextNeg = Math.min((x - num) * i + pos, (x - num - 1) * i + neg);
            pos = nextPos;
            neg = nextNeg;
        }
        
        return Math.min(pos, N + neg) - 1;
    }
}

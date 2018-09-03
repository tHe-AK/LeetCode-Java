class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        
        while (target > 0) {
            target -= ++step;
        }
        
        return target % 2 == 0 ? step : step + 1 + step % 2;
    }
}

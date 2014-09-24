public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int sum = 0;
        int cur = 0;
        int index = -1;
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            
            if (cur < 0) {
                cur = 0;
                index = i;
            }
        }
        
        return sum >= 0 ? index + 1 : -1;
    }
}
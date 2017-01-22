public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int curr = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        
        return sum >= 0 ? start : -1;
    }
}

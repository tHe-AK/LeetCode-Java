public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0; 
        
        for (int machine : machines) {
            total += machine;
        }
        
        if (total % machines.length != 0) {
            return -1;
        }
        
        int avg = total / machines.length;
        int curr = 0;
        int max = 0;
        
        for (int machine: machines) {
            int diff = machine - avg;
            curr += diff;
            max = Math.max(max, Math.max(diff, Math.abs(curr)));
        }
        
        return max;
    }
}

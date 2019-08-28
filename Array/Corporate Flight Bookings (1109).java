class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int k = booking[2];
            res[i] += k;
            
            if (j + 1 < n) {
                res[j + 1] -= k;
            }
        }
        
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        
        return res;
    }
}

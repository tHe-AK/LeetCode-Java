class Solution {
    public int numberOfDays(int Y, int M) {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        if (M == 2 && (Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0))) {
            return 29;
        } else {
            return days[M];
        }
    }
}

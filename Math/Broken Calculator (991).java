class Solution {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            ans++;
        }
        
        return ans + X - Y;
    }
}

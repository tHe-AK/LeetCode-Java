class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) {
            return false;
        } else if (tx == sx) {
            return (ty - sy) % sx == 0;
        } else if (ty == sy) {
            return (tx - sx) % sy == 0;
        } else {
            return tx < ty ? reachingPoints(sx, sy, tx, ty % tx) : reachingPoints(sx, sy, tx % ty, ty);
        }
    }
}

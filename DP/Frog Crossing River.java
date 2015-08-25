public class Solution {
    public int jumpRiver1(int[] river) {
        if (river == null || river.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        helper(river, 0, 1, 0, min);

        return min[0];
    }

    private void helper(int[] river, int cur, int speed, int count, int[] min) {
        if (cur >= river.length) {
            min[0] = Math.min(min[0], count);
            return;
        }

        if (river[cur] == 0) {
            return;
        }

        for (int i = -1; i <= 1; i++) {
            if (speed + i > 0) {
                helper(river, cur + speed + i, speed + i, count + 1, min);
            }
        }
    }

    public int jumpRiver2(int[] river) {
        if (river == null || river.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = river.length;
        int m = (int) Math.sqrt(2 * n);

        if ((m + 1) * m <= 2 * n) {
            m++;
        }

        int x = (1 + m) * m / 2;
        int[][] rec = new int[x][m + 2];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < m + 2; j++) {
                rec[i][j] = Integer.MAX_VALUE;
            }
        }

        rec[0][1] = 0;

        for (int i = 1; i < x; i++) {
            for (int j = 1; j <= m; j++) {
                boolean stone = i < n ? river[i] == 1 : true;

                if (stone && i - j >= 0) {
                    int cur = Math.min(Math.min(rec[i - j][j - 1], rec[i - j][j]), rec[i - j][j + 1]);

                    if (cur != Integer.MAX_VALUE) {
                        rec[i][j] = cur + 1;

                        if (i >= n) {
                            min = Math.min(min, rec[i][j]);
                        }
                    }
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jumpRiver1(new int[] { 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }));
        System.out.println(s.jumpRiver2(new int[] { 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }));
    }
}

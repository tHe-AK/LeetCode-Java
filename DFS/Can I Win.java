import java.util.ArrayList;
import java.util.List;

enum Result {
    Win, Lose, Draw
}

public class Solution {
    Result canIWin(int maxNum, int target) {
        if (maxNum < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> rec = new ArrayList<Integer>();

        for (int i = 0; i < maxNum; i++) {
            rec.add(i + 1);
        }

        return helper(rec, target);
    }

    private Result helper(List<Integer> rec, int target) {
        boolean draw = true;
        int size = rec.size();

        if (size > 0 && rec.get(size - 1) >= target) {
            return Result.Win;
        }

        for (int i = 0; i < size; i++) {
            int cur = rec.remove(i);

            Result result = helper(rec, target - cur);

            if (result == Result.Lose) {
                return Result.Win;
            }

            if (result == Result.Win) {
                draw = false;
            }
            
            rec.add(i, cur);
        }

        if (draw) {
            return Result.Draw;
        } else {
            return Result.Lose;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canIWin(3, 5));
        System.out.println(s.canIWin(3, 4));
        System.out.println(s.canIWin(3, 8));
    }
}

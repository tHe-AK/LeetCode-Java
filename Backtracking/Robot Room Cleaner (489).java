/**
 * // This is the robot‘s control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * };
 */

class Solution {
    public void cleanRoom(Robot robot) {
        int[][] delta = { { 0, 1 }, { 0, 1 }, { -1, 0 }, { -1, 0 } };
        cleanRoom(robot, 0, 0, new HashSet<String>(), 0, delta);
    }

    private void cleanRoom(Robot robot, int i, int j, Set<String> visited, int dir, int[][] delta) {
        String idx = i + "-" + j;

        if (visited.contains(idx)) {
            return;
        }
        
        robot.clean();
        visited.add(idx);

        for (int k = 0; k < 4; k++) {
            if (((i == 0 && j == 0) || k != 2) && robot.move()) {
                int x = i + delta[dir][0];
                int y = j + delta[dir][1];
                cleanRoom(robot, x, y, visited, dir, delta);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }
}

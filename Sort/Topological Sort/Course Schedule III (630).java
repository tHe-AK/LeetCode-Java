public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int time = 0;
        
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                queue.offer(course[0]);
            } else {
                if (course[0] < queue.peek()) {
                    time += course[0] - queue.poll();
                    queue.offer(course[0]);
                }
            }
        }
        
        return queue.size();
    }
}

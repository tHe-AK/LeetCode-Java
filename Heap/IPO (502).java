public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<int[]> capital = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> profit  = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < Capital.length; i++) {
            capital.add(new int[] { Capital[i], Profits[i] });
        }
        
        for (int i = 0; i < k; i++) {
            while (!capital.isEmpty() && capital.peek()[0] <= W) {
                profit.offer(capital.poll()[1]);
            }
            
            if (profit.isEmpty()) {
                break;
            }
            
            W += profit.poll();
        }
        
        return W;
    }
}

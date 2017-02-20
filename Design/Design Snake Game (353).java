public class SnakeGame {
    private int width;
    private int height;
    private int[][] food;
    private int idx;
    private int score;
    private Deque<Integer> queue;
    private Set<Integer> visited;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        idx = 0;
        score = 0;
        queue = new LinkedList<>();
        queue.offer(0);
        visited = new HashSet<>();
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        
        int row = queue.peek() / width;
        int col = queue.peek() % width;
        
        switch (direction) {
            case "U":
                row--;
                break;
            case "D":  
                row++;
                break;
            case "L":   
                col--;
                break;
            default:
                col++;
        }
        
        int head = row * width + col;
        int tail = queue.pollLast();
        visited.remove(tail);
        
        if (row < 0 || row >= height || col < 0 || col >= width || visited.contains(head)) {
            return score = -1;
        }
        
        queue.offerFirst(head);
        visited.add(head); 
        
        if (idx < food.length && row == food[idx][0] && col == food[idx][1]) {
            queue.offer(tail);
            visited.add(tail); 
            idx++;
            score++;
        }
        
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

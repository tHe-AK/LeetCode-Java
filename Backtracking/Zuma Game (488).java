public class Solution {
    public int findMinStep(String board, String hand) {
        int[] map = new int[26];
        
        for (int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        
        return dfs(board, map);
    }
    
    private int dfs(String board, int[] map) {
        if (board.length() == 0) {
            return 0;
        }
        
        int result = -1;
        int i = 0;
        
        for (int j = 1; j <= board.length(); j++) {
            if (j == board.length() || board.charAt(j) != board.charAt(i)) {
                int need = 3 - (j - i);
                int ch = board.charAt(i) - 'A';
                
                if (map[ch] >= need) {
                    map[ch] -= need;
                    int count = dfs(removeConsecutive(board.substring(0, i) + board.substring(j)), map);
                    
                    if (count != -1) {
                        result = result == -1 ? count + need : Math.min(result, count + need);
                    }
                    
                    map[ch] += need;
                }
                
                i = j;
            }
        }
        
        return result;
    }

    private String removeConsecutive(String board) {
        int i = 0;
        
        for (int j = 1; j <= board.length(); j++) {
            if (j == board.length() || board.charAt(j) != board.charAt(i)) {
                if (j - i >= 3) {
                    return removeConsecutive(board.substring(0, i) + board.substring(j));
                }
                
                i = j;
            }
        }
        
        return board;
    }
}

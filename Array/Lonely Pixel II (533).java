public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        int n = picture[0].length;
        Map<String, Integer> map = new HashMap<>();
        int[] col = new int[n];
        
        for (int i = 0; i < m; i++) {
            int row = 0;
            String key = "";
            
            for (int j = 0; j < n; j++) {
                key += picture[i][j];
                
                if (picture[i][j] == 'B') {
                    row++;
                    col[j]++;
                }
            }
            
            if (row == N) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int result = 0;
        
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < key.length(); j++) {
                    if (key.charAt(j) == 'B' && col[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
}

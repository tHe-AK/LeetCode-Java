class Solution {
    public int videoStitching(int[][] clips, int T) {
        int end = 0;
        int step = 0;
        int i = 0;
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
        
        while (end < T) {
            int curr = end;
            
            while (i < clips.length && clips[i][0] <= curr) {
                end = Math.max(end, clips[i++][1]);
            }
            
            if (curr == end) {
                return -1;
            }
            
            step++;
        }
        
        return step;
    }
}

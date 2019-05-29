class Solution {
    public int rectangleArea(int[][] rectangles) {
        int M = 1_000_000_007;
        int N = rectangles.length;
        int[][] events = new int[N * 2][4];
        int i = 0;
        
        for (int[] rect : rectangles) {
            events[i++] = new int[] { rect[0], 0, rect[1], rect[3] };
            events[i++] = new int[] { rect[2], 1, rect[1], rect[3] };
        }
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> intervals = new ArrayList<>();
        int area = 0;
        int prev = events[0][0];
        
        for (int[] event : events) {
            int x = event[0];
            int type = event[1];
            int start = event[2];
            int end = event[3];
            
            area = (area + (int) (1L * (x - prev) * mergeIntervals(intervals) % M)) % M;
            prev = x;
            
            if (type == 0) {
                intervals.add(new int[] { start, end });
                Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                int j = 0;
                
                while (j < intervals.size()) {
                    int[] interval = intervals.get(j);
                    
                    if (interval[0] == start && interval[1] == end) {
                        break;
                    }
                    
                    j++;
                }
                
                intervals.remove(j);
            }
        }
        
        return area;
    }
    
    private int mergeIntervals(List<int[]> intervals) {
        int len = 0;
        int start = -1;
        int end = -1;
            
        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            
            if (end < interval[0]) {
                len += end - start;
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        
        len += end - start;
        return len;
    }
}

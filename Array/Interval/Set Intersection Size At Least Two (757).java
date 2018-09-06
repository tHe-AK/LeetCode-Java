class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        int count = 2;
        int low = intervals[0][1] - 1;
        int high = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            
            if (low < left && left <= high) {
                low = high;
                high = right;
                count++;
            } else if (high < left) {
                low = right - 1;
                high = right;
                count += 2;
            }
        }
        
        return count;
    }
}

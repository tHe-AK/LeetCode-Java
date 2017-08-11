/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        
        int count = 0;
        int min = intervals[0].end;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < min) {
                count++;
            } else {
                min = intervals[i].end;
            }
        }
        
        return count;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        int count = 0;
        int min = intervals[0].end;
        
        for (int i = 1; i < intervals.length; i++) {
            if (min > intervals[i].start) {
                count++;
                min = Math.min(min, intervals[i].end);
            } else {
                min = intervals[i].end;
            }
        }
        
        return count;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        int len = intervals.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int count = 1;

        for (int i = 1; i < len; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start) {
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + 1;
            count = Math.max(count, dp[i]);
        }
        
        return len - count;
    }
}

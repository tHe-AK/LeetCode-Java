class Solution {
    public int rectangleArea(int[][] rectangles) {
        int M = 1_000_000_007;
        int N = rectangles.length;
        int[][] events = new int[N * 2][4];
        int i = 0;
        
        for (int[] rect : rectangles) {
            events[i++] = new int[] { rect[0], 1, rect[1], rect[3] };
            events[i++] = new int[] { rect[2], -1, rect[1], rect[3] };
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
            
            if (x != prev) {
                area = (area + (int) (1L * (x - prev) * mergeIntervals(intervals) % M)) % M;
                prev = x;
            }
            
            if (type == 1) {
                intervals.add(new int[] { start, end });
                Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int j = 0; j < intervals.size(); j++) {
                    int[] interval = intervals.get(j);
                    
                    if (interval[0] == start && interval[1] == end) {
                        intervals.remove(j);
                        break;
                    }
                }
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
            }
            
            end = Math.max(end, interval[1]);
        }
        
        len += end - start;
        return len;
    }
}

class SegmentTreeNode {
    public int start;
    public int end;
    public int val;
    public int count;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SegmentTree {
    private SegmentTreeNode root;
    private List<Integer> list;
    
    public SegmentTree(List<Integer> list) {
        this.list = list;
        root = buildTree(0, list.size() - 1);
    }
    
    private SegmentTreeNode buildTree(int start, int end) {
        if (start + 1 == end) {
            return new SegmentTreeNode(start, end);
        } else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            root.left = buildTree(start, mid);
            root.right = buildTree(mid, end);
            return root;
        }
    }
    
    public void update(int start, int end, int count) {
        update(root, list.indexOf(start), list.indexOf(end), count);
    }
    
    private int update(SegmentTreeNode root, int start, int end, int count) {
        int diff = 0;
        
        if (root.start + 1 == root.end) {
            root.count += count;
            int dist = list.get(end) - list.get(start);
            
            if (root.count == 1 && count == 1) {
                diff = dist;
            }
            
            if (root.count == 0) {
                diff = -dist;
            }
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            
            if (end <= mid) {
                diff += update(root.left, start, end, count);
            } else if (mid <= start) {
                diff += update(root.right, start, end, count);
            } else {
                diff += update(root.left, start, mid, count) + update(root.right, mid, end, count);
            }
        }
        
        root.val += diff;
        return diff;
    }
    
    public int getSum() {
        return root.val;
    }
}

public class Solution {
    public int rectangleArea(int[][] rectangles) {
        int M = 1_000_000_007;
        int N = rectangles.length;
        Set<Integer> set = new TreeSet<>();
        int[][] events = new int[N * 2][4];
        int i = 0;
        
        for (int[] rect : rectangles) {
            events[i++] = new int[] { rect[0], 1, rect[1], rect[3] };
            events[i++] = new int[] { rect[2], -1, rect[1], rect[3] };
            set.add(rect[1]);
            set.add(rect[3]);
        }
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> list = new ArrayList<>(set);
        SegmentTree tree = new SegmentTree(list);
        int area = 0;
        int prev = events[0][0];
        
        for (int[] event : events) {
            int x = event[0];
            int type = event[1];
            int start = event[2];
            int end =  event[3];
            
            if (x != prev) {
                area = (area + (int) (1L * (x - prev) * tree.getSum() % M)) % M;
                prev = x;
            }
            
            if (type == 1) {
                tree.update(start, end, 1);
            } else {
                tree.update(start, end, -1);
            }
        }
        
        return area;
    }
}

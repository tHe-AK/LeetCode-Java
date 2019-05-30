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
    
    public SegmentTreeNode(int start, int end, int val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }
}

class SegmentTree {
    private SegmentTreeNode root;
    
    public SegmentTree(List<Integer> list) {
        root = buildTree(0, list.size() - 1, list);
    }
    
    private SegmentTreeNode buildTree(int start, int end, List<Integer> list) {
        if (start + 1 == end) {
            return new SegmentTreeNode(start, end, list.get(end) - list.get(start));
        } else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            root.left = buildTree(start, mid, list);
            root.right = buildTree(mid, end, list);
            return root;
        }
    }
    
    public void update(int start, int end, int diff) {
        update(root, start, end, diff);
    }
    
    private void update(SegmentTreeNode root, int start, int end, int diff) {
        if (root.start + 1 == root.end) {
            root.count += diff;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            
            if (end <= mid) {
                update(root.left, start, end, diff);
            } else if (mid <= start) {
                update(root.right, start, end, diff);
            } else {
                update(root.left, start, mid, diff);
                update(root.right, mid, end, diff);
            }
        }
    }
    
    public int getSum() {
        return getSum(root);
    }
    
    private int getSum(SegmentTreeNode root) {
        if (root.start + 1 == root.end) {
            return root.count > 0 ? root.val : 0;
        } else {
            return getSum(root.left) + getSum(root.right);
        }
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
            int start = list.indexOf(event[2]);
            int end =  list.indexOf(event[3]);
            
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

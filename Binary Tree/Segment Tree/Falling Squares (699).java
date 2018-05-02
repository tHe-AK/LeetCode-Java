class Solution {
    private class SegmentTreeNode {
        public int start;
        public int end;
        public int max;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }

    private class SegmentTree {
        private SegmentTreeNode root;

        public SegmentTree(int size) {
            root = build(0, size - 1);
        }

        private SegmentTreeNode build(int low, int high) {
            if (low == high) {
                return new SegmentTreeNode(low, high, 0);
            } else {
                int mid = (high - low) / 2 + low;
                SegmentTreeNode node = new SegmentTreeNode(low, high, 0);
                node.left = build(low, mid);
                node.right = build(mid + 1, high);

                return node;
            }
        }

        public void update(int low, int high, int height) {
            update(root, low, high, height);
        }

        private void update(SegmentTreeNode node, int low, int high, int height) {
            if (node.start == node.end) {
                node.max = height;
                return;
            }
            
            int mid = (node.end - node.start) / 2 + node.start;
            
            if (high <= mid) {
                update(node.left, low, high, height);
            } else if (mid < low) {
                update(node.right, low, high, height);
            } else {
                update(node.left, low, mid, height);
                update(node.right, mid + 1, high, height);
            }
            
            node.max = Math.max(node.left.max, node.right.max);
        }

        public int getMax(int low, int high) {
            return getMax(root, low, high);
        }
        
        private int getMax(SegmentTreeNode node, int low, int high) {
            if (node.start == low && node.end == high) {
                return node.max;
            }
            
            int mid = (node.end - node.start) / 2 + node.start;
            
            if (high <= mid) {
                return getMax(node.left, low, high);
            } else if (mid < low) {
                return getMax(node.right, low, high);
            } else {
                return Math.max(getMax(node.left, low, mid), getMax(node.right, mid + 1, high));
            }
        }
    }
    
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] pos : positions) {
            set.add(pos[0]);
            set.add(pos[0] + pos[1] - 1);
        }
        
        int i = 0;
        int size = set.size();
        
        for (Integer pos : set) {
            map.put(pos, i++);
        }
        
        SegmentTree tree = new SegmentTree(size);
        int max = 0;
        
        for (int[] pos : positions) {
            int x = map.get(pos[0]);
            int y = map.get(pos[0] + pos[1] - 1);
            int newHeight = tree.getMax(x, y) + pos[1];
            tree.update(x, y, newHeight);
            max = Math.max(max, newHeight);
            res.add(max);
        }
        
        return res;
    }
}

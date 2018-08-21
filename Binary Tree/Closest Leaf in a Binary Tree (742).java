class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        dfs(root, k, path);
        minDist(root, map);
        int min = Integer.MAX_VALUE;
        int leaf = 0;

        for (int i = 0; i < path.size(); i++) {
            int[] pair = map.get(path.get(i));
            int dist = path.size() - i - 1 + pair[0];
            System.out.println(path.get(i) + ":" + (path.size() - i - 1) + "+" + pair[0]);

            if (dist < min) {
                min = dist;
                leaf = pair[1];
            }
        }

        return leaf;
    }

    private boolean dfs(TreeNode root, int k, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == k) {
            return true;
        } else {
            if (dfs(root.left, k, path)) {
                return true;
            }

            if (dfs(root.right, k, path)) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }
    }

    private int[] minDist(TreeNode root, Map<Integer, int[]> map) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, 0 };
        }

        int[] pair = new int[2];

        if (root.left == null && root.right == null) {
            pair[0] = 0;
            pair[1] = root.val;
        } else {
            int[] left = minDist(root.left, map);
            int[] right = minDist(root.right, map);
            pair[0] = Math.min(left[0], right[0]) + 1;
            pair[1] = left[0] < right[0] ? left[1] : right[1];
        }

        map.put(root.val, pair);
        return pair;
    }
}

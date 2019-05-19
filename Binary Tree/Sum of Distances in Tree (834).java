class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] count = new int[N];
        int[] dist = new int[N];
        List<Integer>[] tree = new List[N];
        
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            tree[i].add(j);
            tree[j].add(i);
        }
        
        postorder(tree, 0, -1, count, dist);
        preorder(tree, 0, -1, count, dist);
        
        return dist;
    }
    
    private void postorder(List<Integer>[] tree, int i, int pre, int[] count, int[] dist) {        
        for (Integer j : tree[i]) {
            if (j != pre) {
                postorder(tree, j, i, count, dist);
                count[i] += count[j];
                dist[i] += dist[j] + count[j];
            }
        }
        
        count[i]++;
    }
    
    private void preorder(List<Integer>[] tree, int i, int pre, int[] count, int[] dist) {        
        for (Integer j : tree[i]) {
            if (j != pre) {
                dist[j] = dist[i] + (tree.length - count[j]) - count[j];
                preorder(tree, j, i, count, dist);
            }
        }
    }
}

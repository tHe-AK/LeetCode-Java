class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = postorder(root, map);
        
        if (sum == 0) {
            return map.get(sum) > 1;
        } else {
            return map.containsKey(sum / 2);
        }
    }
    
    private int postorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
        	    return 0;
        }

        int sum = root.val + postorder(root.left, map) + postorder(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        return sum;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        
        sb.append(root.val + " ");
        
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Scanner sc = new Scanner(data);
        
        return deserialize(sc);
    }
    
    private TreeNode deserialize(Scanner sc) {
        String str = sc.next();
        
        if (str.equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(sc);
        root.right = deserialize(sc);
        
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        
        return String.join(" ", list);
    }
    
    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("#");
            return;
        }
        
        list.add(root.val + "");
        
        serialize(root.left, list);
        serialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(" ");
        int[] idx = { 0 };
        
        return deserialize(list, idx);
    }
    
    private TreeNode deserialize(String[] list, int[] idx) {
        String str = list[idx[0]++];
        
        if (str.equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(list, idx);
        root.right = deserialize(list, idx);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

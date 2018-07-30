class TreeNode {
    public String val;
    public List<TreeNode> children;
    
    TreeNode(String val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val + " ");
        
        for (TreeNode child : root.children) {
            serialize(child, sb);
        }
        
        sb.append("# ");
    }
    
    public TreeNode deserialize(String str) {        
        if (str.isEmpty()) {
            return null;
        }
        
        return deserialize(Arrays.asList(str.split(" ")).iterator());
    }
    
    private TreeNode deserialize(Iterator<String> it) {
        String str = it.next();
        
        if (str.equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(str);
        TreeNode child = deserialize(it);
        
        while (child != null) {
            root.children.add(child);
            child = deserialize(it);
        }
        
        return root;
    }
}

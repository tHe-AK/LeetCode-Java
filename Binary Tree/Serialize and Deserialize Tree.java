import java.util.*;

class TreeNode {
    String val;
    List<TreeNode> children;
    
    TreeNode(String val) {
        this.val = val;
        children = new ArrayList<TreeNode>();
    }
}

public class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val + " ");
        
        for (TreeNode child : root.children) {
            serializeHelper(child, sb);
        }
        
        sb.append("] ");
    }
    
    public TreeNode deserialize(String tree) {
        if (tree == null) {
            return null;
        }
        
        Scanner sc = new Scanner(tree);
        
        return deserializeHelper(sc);
    }
    
    private TreeNode deserializeHelper(Scanner sc) {
        String val;
        
        if (!sc.hasNext() || (val = sc.next()).equals("]")) {
            return null;
        }
        
        TreeNode root = new TreeNode(val);

        while (sc.hasNext()) {
            TreeNode child = deserializeHelper(sc);
            
            if (child == null) {
                break;
            }
            else {
                root.children.add(child);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        a.children.add(b);
        a.children.add(c);
        b.children.add(d);
        
        String tree = s.serialize(a);
        System.out.println(tree);
        
        TreeNode root = s.deserialize(tree);
        System.out.println(root.val);
        
        for (TreeNode child : root.children) {
            System.out.println(child.val);
        }
        
        for (TreeNode child : root.children.get(0).children) {
            System.out.println(child.val);
        }
    }
}

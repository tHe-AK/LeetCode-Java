import java.util.*;

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
        
        sb.append("] ");
    }
    
    public TreeNode deserialize(String data) {
        Scanner sc = new Scanner(data);
        
        return deserialize(sc);
    }
    
    private TreeNode deserialize(Scanner sc) {
        String str;
        
        if (!sc.hasNext() || (str = sc.next()).equals("]")) {
            return null;
        }
        
        TreeNode root = new TreeNode(str);

        while (true) {
            TreeNode child = deserialize(sc);
            
            if (child == null) {
                break;
            } else {
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
        
        String data = s.serialize(a);
        System.out.println(data);
        
        TreeNode root = s.deserialize(data);
        System.out.println(root.val);
        
        for (TreeNode child : root.children) {
            System.out.println(child.val);
        }
        
        for (TreeNode child : root.children.get(0).children) {
            System.out.println(child.val);
        }
    }
}

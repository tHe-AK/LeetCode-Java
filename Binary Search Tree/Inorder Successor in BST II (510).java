public class Solution {
    public TreeNode inorderSuccessor(TreeNode p) {
        TreeNode successor = null;
        TreeNode node = p.right;
      
        while (node != null) {
            successor = node;
            node = node.left;
        }
      
        if (successor != null) {
            return successor;
        }
      
        node = p;
      
        while (node != null) {
            TreeNode parent = node.parent;
          
            if (parent != null && parent.left == node) {
              return parent;
            } else {
              node = parent;
            }
        }
        
        return null;
    }
}

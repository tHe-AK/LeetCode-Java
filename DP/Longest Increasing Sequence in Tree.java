import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    int len = 0;
    List<TreeNode> children = new ArrayList<TreeNode>();
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public List<Integer> longest_seq(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        int[] max = new int[1];
        int[] start = new int[1];
        
        helper(root, max, start);
        
        for (int i = 0; i < max[0]; i++) {
            result.add(start[0] + i);
        }
        
        return result;
    }
    
    private void helper(TreeNode root, int[] max, int[] start) {
        update(root);
        
        if (max[0] < root.len) {
            max[0] = root.len;
            start[0] = root.val;    
        }
        
        for (TreeNode child : root.children) {
            helper(child, max, start);
        }
    }
    
    private void update(TreeNode root) {
        if (root.len > 0) {
            return;
        }
        
        for (TreeNode child : root.children) {
            if (root.val + 1 == child.val) {
                update(child);
                root.len = Math.max(root.len, child.len);
            }
        }
        
        root.len++;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(4);
        TreeNode j = new TreeNode(5);
        TreeNode k = new TreeNode(8);
        TreeNode l = new TreeNode(3);
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        a.children.add(e);
        b.children.add(f);
        b.children.add(g);
        c.children.add(h);
        d.children.add(i);
        d.children.add(j);
        e.children.add(k);
        h.children.add(l);
        
        List<Integer> result = s.longest_seq(a);
        System.out.println(result.toString());
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode str2tree(String s) {
        int len = s.length();
        
        if (len == 0) {
            return null;
        }
        
        int idx = s.indexOf("(");
        
        if (idx == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        
        int val = Integer.parseInt(s.substring(0, idx));
        TreeNode root = new TreeNode(val);
        int start = idx;
        int count = 0;
        
        for (int i = start; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                
                if (count == 0) {
                    if (start == idx) {
                        root.left = str2tree(s.substring(start + 1, i));
                        start = i + 1;
                    } else {
                        root.right = str2tree(s.substring(start + 1, i));
                    }
                }
            }
        }
        
        return root;
    }
}

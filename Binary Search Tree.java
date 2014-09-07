import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int size;
    
    TreeNode(int val, int size) {
        this.val = val;
        this.size = size;
    }
}

public class Solution {
    private TreeNode root;
    
    public int size() {
        return size(root);
    }
    
    private int size(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        else {
            return cur.size;
        }
    }
    
    public void insert(int val) {
        root = insert(root, val);
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, 1);
        }
        
        if (root.val == val) {
            throw new RuntimeException("Can not insert");
        }
        else if (root.val < val) {
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }
        
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }
    
    public void delete(int val) {
        root = delete(root, val);
    }
    
    private TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            throw new RuntimeException("Can not delete");
        }
        
        if (val == root.val) {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                root.val = deleteHelper(root.left);
                root.left = delete(root.left, root.val);
            }
        }
        else if (val < root.val) {
            root.left = delete(root.left, val);
        }
        else {
            root.right = delete(root.right, val);
        }
        
        return root;
    }
    
    private int deleteHelper(TreeNode root) {
        if (root.right != null) {
            root = root.right;
        }
        
        return root.val;
    }
    
    public boolean search(int val) {
        TreeNode node = search(root, val);
        return node != null ? true : false;
    }
    
    private TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        
        if (root.val == val) {
            return root;
        }
        else if (root.val < val) {
            return search(root.right, val);
        }
        else {
            return search(root.left, val);
        }
    }
    
    public int select(int k) {
        if (k < 1 || k > size(root)) {
            throw new IllegalArgumentException();
        }
        
        TreeNode node = select(root, k);
        return node.val;
    }
    
    private TreeNode select(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        
        int cur = size(root.left) + 1;
        if (cur == k) {
            return root;
        }
        else if (cur < k) {
            return select(root.right, k - cur);
        }
        else {
            return select(root.left, k);
        }
    }
    
    public void traverseRange(int x, int y) {
        traverseRange(root, x, y);
    }
    
    private void traverseRange(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        
        if (x < root.val) {
            traverseRange(root.left, x, y);
        }
        
        if (x <= root.val && root.val <= y) {
            System.out.println(root.val);
        }
        
        if (root.val < y) {
            traverseRange(root.right, x, y);
        }
    }
    
    public Iterator<TreeNode> preorderIterator() {
        return new PreorderIterator();
    }
    
    private class PreorderIterator implements Iterator<TreeNode> {
        private Stack<TreeNode> stack;
        
        public PreorderIterator() {
            stack = new Stack<TreeNode>();
            if (root != null) {
                stack.push(root);
            }
        }
        
        public boolean hasNext() {
            return !stack.empty();
        }

        public TreeNode next() {
            if (hasNext()) {
                TreeNode cur = stack.pop();
                
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                
                return cur;
            }
            else {
                return null;
            }
        }
    }
    
    public Iterator<TreeNode> inorderIterator() {
        return new InorderIterator();
    }
    
    private class InorderIterator implements Iterator<TreeNode> {
        private Stack<TreeNode> stack;
        
        public InorderIterator() {
            stack = new Stack<TreeNode>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        public boolean hasNext() {
            return !stack.empty();
        }

        public TreeNode next() {
            if (hasNext()) {
                TreeNode temp = stack.pop();
                TreeNode cur = temp.right;
                
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                
                return temp;
            }
            else {
                return null;
            }
        }
    }
    
    public Iterator<TreeNode> postorderIterator() {
        return new PostorderIterator();
    }
    
    private class PostorderIterator implements Iterator<TreeNode> {
        private Stack<TreeNode> stack;
        private TreeNode pre;
        
        public PostorderIterator() {
            stack = new Stack<TreeNode>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        public boolean hasNext() {
            return !stack.empty();
        }

        public TreeNode next() {
            if (hasNext()) {        
                while (stack.peek().right != null && stack.peek().right != pre) {
                    TreeNode cur = stack.peek().right;
                    
                    while (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                }
                
                pre = stack.pop();
                return pre;
            }
            else {
                return null;
            }
        }
    }
    
    public Iterator<TreeNode> levelorderIterator() {
        return new LevelorderIterator();
    }
    
    private class LevelorderIterator implements Iterator<TreeNode> {
        private Queue<TreeNode> queue;
        
        public LevelorderIterator() {
            queue = new LinkedList<TreeNode>();
            if (root != null) {
                queue.add(root);
            }
        }
        
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        
        public TreeNode next() {
            if (hasNext()) {
                TreeNode cur = queue.remove();
                
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                
                return cur;
            }
            else {
                return null;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        s.insert(3);
        s.insert(1);
        s.insert(5);
        s.insert(9);
        s.insert(7);
    }
}

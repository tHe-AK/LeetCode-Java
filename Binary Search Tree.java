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
	
	private TreeNode insert(TreeNode p, int val) {
		if (p == null) {
			return new TreeNode(val, 1);
		}
		
		if (p.val == val) {
			throw new RuntimeException("Can not insert");
		}
		else if (p.val < val) {
			p.right = insert(p.right, val);
		}
		else {
			p.left = insert(p.left, val);
		}
		
		p.size = size(p.left) + size(p) + 1;
		return p;
	}
	
	public void delete(int val) {
		root = delete(root, val);
	}
	
	private TreeNode delete(TreeNode p, int val) {
		if (p == null) {
			throw new RuntimeException("Can not delete");
		}
		
		if (val == p.val) {
			if (p.left == null) {
				return p.right;
			}
			else if (p.right == null) {
				return p.left;
			}
			else {
				p.val = deleteHelper(p.left);
				p.left = delete(p.left, p.val);
			}
		}
		else if (val < p.val) {
			p.left = delete(p.left, val);
		}
		else {
			p.right = delete(p.right, val);
		}
		
		return p;
	}
	
	private int deleteHelper(TreeNode p) {
		if (p.right != null) {
			p = p.right;
		}
		
		return p.val;
	}
	
	public boolean search(int val) {
		TreeNode node = search(root, val);
		return node != null ? true : false;
	}
	
	private TreeNode search(TreeNode p, int val) {
		if (p == null) {
			return null;
		}
		
		if (p.val == val) {
			return p;
		}
		else if (p.val < val) {
			return search(p.right, val);
		}
		else {
			return search(p.left, val);
		}
	}
	
	public int select(int k) {
		if (k < 1 || k > size(root)) {
			throw new IllegalArgumentException();
		}
		
		TreeNode node = select(root, k);
		return node.val;
	}
	
	private TreeNode select(TreeNode p, int k) {
		if (p == null) {
			return null;
		}
		
		int cur = size(p.left) + 1;
		if (cur == k) {
			return p;
		}
		else if (cur < k) {
			return select(p.right, k - cur);
		}
		else {
			return select(p.left, k);
		}
	}
	
	public void traverseRange(int x, int y) {
		traverseRange(root, x, y);
	}
	
	private void traverseRange(TreeNode p, int x, int y) {
		if (p == null) {
			return;
		}
		
		if (x < p.val) {
			traverseRange(p.left, x, y);
		}
		
		if (x <= p.val && p.val <= y) {
			System.out.println(p.val);
		}
		
		if (p.val < y) {
			traverseRange(p.right, x, y);
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

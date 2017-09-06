class Solution {
	public List<TreeNode> removeNodes(TreeNode root, Set<Integer> set) {
		List<TreeNode> res = new ArrayList<>();

		if (removeNodes(root, set, res) != null) {
			res.add(root);
		}

		return res;
	}

	private TreeNode removeNodes(TreeNode root, Set<Integer> set, List<TreeNode> res) {
		if (root == null) {
			return null;
		}

		root.left = removeNodes(root.left, set, res);
		root.right = removeNodes(root.right, set, res);

		if (set.contains(root.val)) {
			if (root.left != null) {
				res.add(root.left);
			}

			if (root.right != null) {
				res.add(root.right);
			}

			return null;
		} else {
			return root;
		}
	}
}

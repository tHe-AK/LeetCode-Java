public class Solution {
	/**
	 * @param nums
	 *            The rotated sorted array
	 * @return: The recovered sorted array
	 */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() <= 1) {
			return;
		}

		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i) > nums.get(i + 1)) {
				helper(nums, 0, i);
				helper(nums, i + 1, nums.size() - 1);
				helper(nums, 0, nums.size() - 1);
			}
		}
	}

	private void helper(ArrayList<Integer> nums, int start, int end) {
		while (start < end) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
		}
	}
}

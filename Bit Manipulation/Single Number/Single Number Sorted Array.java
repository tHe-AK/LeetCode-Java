public class Solution {
	public int singleNum(int[] array) {
		if (array == null || array.length % 2 == 0) {
			throw new IllegalArgumentException();
		}
		
		int low = 0;
		int high = array.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (low == high || (array[mid] != array[mid - 1] && array[mid] != array[mid + 1])) {
				return array[mid];
			}
			else if (array[mid] == array[mid - 1]) {
				if ((mid - 1) % 2 == 0) {
					low = mid + 1;
				}
				else {
					high = mid - 2;
				}
			}
			else {
				if (mid % 2 == 0) {
					low = mid + 2;
				}
				else {
					high = mid - 1;
				}
			}
		}
		
		throw new IllegalArgumentException();
	}
}
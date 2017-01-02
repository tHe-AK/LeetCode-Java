public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int target = -num[i];
                int low = i + 1;
                int high = num.length - 1;

                while (low < high) {
                    int sum = num[low] + num[high];

                    if (sum == target) {
                        result.add(Arrays.asList(num[i], num[low], num[high]));

                        low++;
                        high--;

                        while (low < high && num[low] == num[low - 1]) {
                            low++;
                        }

                        while (low < high && num[high] == num[high + 1]) {
                            high--;
                        }
                    }
                    else if (sum < target) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        
        return result;
    }
}

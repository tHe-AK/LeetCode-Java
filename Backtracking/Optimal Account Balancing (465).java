public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Long> map = new HashMap<>();
        
        for (int[] t : transactions){
            map.put(t[0], map.getOrDefault(t[0], 0L) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0L) + t[2]);
        }        

        List<Long> list = new ArrayList<>();
        
        for (long val: map.values()){
            if (val != 0) {
                list.add(val);
            }
        }

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        dfs(list.toArray(new Long[0]), 0, 0, min);
        
        return min[0];
    }
    
    private void dfs(Long[] rec, int start, int count, int[] min) {
        int len = rec.length;
        
        while (start < len && rec[start] == 0) {
            start++;
        }
        
        if (start == len) {
            min[0] = Math.min(min[0], count);
            return;
        }
        
        for (int i = start + 1; i < len; i++) {
            if (rec[start] * rec[i] < 0) {
                rec[i] += rec[start];
                dfs(rec, start + 1, count + 1, min);
                rec[i] -= rec[start];
            }
        }
    }
}

public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Long> map = new HashMap<>();
        
        for (int[] t : transactions){
            map.put(t[0], map.getOrDefault(t[0], 0L) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0L) + t[2]);
        }        

        List<Long> list = new ArrayList<>();
        
        for (long val: map.values()){
            if (val != 0) {
                list.add(val);
            }
        }

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
		dfs(list.toArray(new Long[0]), 0, 0, 0, 0, list.size(), new boolean[list.size()], min);
        
        return min[0];
    }
    
	private void dfs(Long[] nums, int start, long target, int count, int total, int remaining, boolean[] visited, int[] min) {
		if (target == 0 && count > 0) {
			total += count - 1;

			if (remaining == 0) {
				min[0] = Math.min(min[0], total);
			} else {
				dfs(nums, 0, 0, 0, total, remaining, visited, min);
			}
		} else {
			for (int i = start; i < nums.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(nums, i + 1, target - nums[i], count + 1, total, remaining - 1, visited, min);
					visited[i] = false;
				}
			}
		}
	}
}

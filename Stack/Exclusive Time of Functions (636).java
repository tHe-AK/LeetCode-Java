public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int curr = Integer.parseInt(strs[2]);
            
            if (strs[1].equals("start")) {
                if (!stack.empty()) {
                    res[stack.peek()] += curr - pre;
                }
                
                pre = curr;
                stack.push(id);
            } else {
                res[id] += curr - pre + 1;
                pre = curr + 1;
                stack.pop();
            }
        }
        
        return res;
    }
}

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        Stack<Integer> stack = new Stack<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int remaining = 0;
        
        while (i >= 0 || j >= 0 || remaining != 0) {
            if (i >= 0) {
                remaining += arr1[i--];
            }
            
            if (j >= 0) {
                remaining += arr2[j--];
            }
            
            stack.push(remaining & 1);
            remaining = -(remaining >> 1);
        }
        
        while (stack.size() > 1 && stack.peek() == 0) {
            stack.pop();
        }
        
        int[] res = new int[stack.size()];
        
        for (int k = 0; k < res.length; k++) {
            res[k] = stack.pop();
        }
        
        return res;
    }
}

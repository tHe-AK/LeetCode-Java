public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int len = height.length;
        int[] rec = new int[len + 1];
        System.arraycopy(height, 0, rec, 0, height.length);

        Stack<Integer> s = new Stack<Integer>();
        int area = 0;
        int i = 0;
        while (i < rec.length) {
            if (s.empty() == true || rec[i] >= rec[s.peek()]) {
                s.push(i);
                i++;
            }
            else {
                int cur = s.pop();
                if (s.empty() == true) {
                    area = Math.max(area, i * rec[cur]);
                }
                else {
                    area = Math.max(area, (i - s.peek() - 1) * rec[cur]);
                }
            }
        }
        
        return area;
    }
}

public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        boolean negative = false;
        boolean positive = false;
        int size = points.size();

        for (int i = 0; i < size; i++) {
            List<Integer> A = points.get(i);
            List<Integer> B = points.get((i + 1) % size);
            List<Integer> C = points.get((i + 2) % size);
            
            int crossProduct = (A.get(0) - B.get(0)) * (C.get(1) - B.get(1)) - (C.get(0) - B.get(0)) * (A.get(1) - B.get(1));
            
            if (crossProduct < 0) {
                negative = true;
            } else if (crossProduct > 0) {
                positive = true;
            }
            
            if (negative && positive) {
                return false;
            }
        }
        
        return true;
    }
}

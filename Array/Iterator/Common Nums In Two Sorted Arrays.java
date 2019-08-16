import java.util.*;

class Solution implements Iterator<Integer> {
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;
    private Integer num1;
    private Integer num2;
    
    public Solution(Iterator<Integer> it1, Iterator<Integer> it2) {
        this.it1 = it1;
        this.it2 = it2;
        num1 = null;
        num2 = null;
    }
    
    @Override
    public boolean hasNext() {
        while ((num1 != null || it1.hasNext()) && (num2 != null || it2.hasNext())) {
            if (num1 == null) {
                num1 = it1.next();
            }
            
            if (num2 == null) {
                num2 = it2.next();
            }
            
            if (num1 == num2) {
                return true;
            } else if (num1 < num2) {
                num1 = null;
            } else {
                num2 = null;
            }
        }
        
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        
        Integer res = num1;
        num1 = null;
        num2 = null;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution(Arrays.asList(1, 1).iterator(), Arrays.asList(1, 1, 1, 4).iterator());
        
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

}

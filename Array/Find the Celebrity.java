/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 1; i < n; i++) {
            if (knows(cur, i)) {
                cur = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != cur && (!knows(i, cur) || knows(cur, i))) {
                return -1;
            }
        }
        
        return cur;
    }
}

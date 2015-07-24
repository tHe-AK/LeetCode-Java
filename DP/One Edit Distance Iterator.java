import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public boolean isDistanceZeroOrOne(Iterator<Integer> a, Iterator<Integer> b) {
        boolean insertA = false;
        boolean insertB = false;
        boolean replace = false;
        boolean diff = false;
        
        int preA = 0;
        int preB = 0;
        int curA = 0;
        int curB = 0;
        
        while (a.hasNext() && b.hasNext()) {
            curA = a.next();
            curB = b.next();
            
            if (!insertA && !insertB && !replace) {
                if (curA != curB) {
                    insertA = true;
                    insertB = true;
                    replace = true;
                    diff = true;
                }
            }
            else {
                if (insertA && curA != preB) {
                    insertA = false;
                }
                
                if (insertB && curB != preA) {
                    insertB = false;
                }
                
                if (replace && curA != curB) {
                    replace = false;
                }
                
                if (!insertA && !insertB && !replace) {
                    return false;
                }
            }
            
            preA = curA;
            preB = curB;
        }
        
        if (a.hasNext()) {
            curA = a.next();
            
            return !a.hasNext() && (!diff || (insertA && curA == preB));
        }
        else if (b.hasNext()) {
            curB = b.next();
            
            return !b.hasNext() && (!diff || (insertB && curB == preA));
        }
        else {
            return !diff || replace;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);
        
        System.out.println(s.isDistanceZeroOrOne(a.iterator(), b.iterator()));
    }
}

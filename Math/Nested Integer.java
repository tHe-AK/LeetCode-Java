import java.util.ArrayList;
import java.util.List;

class NestedInteger {
    public Integer num;
    public List<NestedInteger> list;
    
    // Returns true if this NestedInteger holds a single integer, rather than a
    // nested list
    public boolean isInteger() {
        if (num == null) {
            return false;
        }
        else {
            return true;
        }
    }

    // Returns the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Returns null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if (isInteger()) {
            return num;
        }
        else {
            return null;
        }
    }

    // Returns the nested list that this NestedInteger holds, if it holds a
    // nested list
    // Returns null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (isInteger()) {
            return null;
        }
        else {
            return list;
        }
    }
    
    public NestedInteger() {
        list = new ArrayList<NestedInteger>();
    }
    
    public NestedInteger(Integer num) {
        this.num = num;
    }
}

public class Solution {
    public Integer NestedIntegerSumRecursion(NestedInteger n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        
        return helper(n, 0);
    }
    
    private Integer helper(NestedInteger n, int level) {
        if (n.isInteger()) {
            return n.getInteger() * level;
        }
        
        Integer sum = 0;
        for (NestedInteger i : n.getList()) {
            sum += helper(i, level + 1);
        }
                
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        NestedInteger n1 = new NestedInteger();
        NestedInteger n2 = new NestedInteger();
        NestedInteger n3 = new NestedInteger();
        NestedInteger n4 = new NestedInteger(5);
        NestedInteger n5 = new NestedInteger(7);
        NestedInteger n6 = new NestedInteger(8);
        NestedInteger n7 = new NestedInteger(1);
        NestedInteger n8 = new NestedInteger(2);
        n3.getList().add(n5);
        n3.getList().add(n6);
        n2.getList().add(n3);
        n2.getList().add(n7);
        n1.getList().add(n4);
        n1.getList().add(n2);
        n1.getList().add(n8);

        System.out.println(s.NestedIntegerSumRecursion(n1));
    }
}

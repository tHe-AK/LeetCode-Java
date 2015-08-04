/*
public class Iterator {
    public int get_next();
    public boolean has_next();
}
*/

public class ZigzagIterator {
    private boolean flag;
    private Iterator a;
    private Iterator b;
    
    public ZigzagIterator(Iterator a, Iterator b) {
        flag = true;
        a = this.a;
        b = this.b;
    }
    
    public boolean hasNext() {
        return a.hasNext() || b.hasNext();
    }
    
    public Object next() {
        if (!has_next()) {
            return null;
        }
        
        if (a.hasNext() && b.hasNext()) {
            if (flag) {
                flag = false;
                return a.next();
            }
            else {
                flag = true;
                return b.next();
            }
        }
        else {
            if (a.hasNext()) {
                return a.next();
            }
            else {
                return b.next();
            }
        }
    }
}

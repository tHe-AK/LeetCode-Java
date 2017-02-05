public class Vector2D implements Iterator<Integer> {
    private int idx1;
    private int idx2;
    private List<List<Integer>> vec2d;
    
    public Vector2D(List<List<Integer>> vec2d) {
        idx1 = 0;
        idx2 = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return vec2d.get(idx1).get(idx2++);
    }

    @Override
    public boolean hasNext() {
        while (idx1 < vec2d.size()) {
            if (idx2 < vec2d.get(idx1).size()) {
                return true;
            } else {
                idx1++;
                idx2 = 0;
            }
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> itr1;
    private Iterator<Integer> itr2;
    
    public Vector2D(List<List<Integer>> vec2d) {
        itr1 = vec2d.iterator();
        itr2 = null;
    }

    @Override
    public Integer next() {
        return itr2.next();
    }

    @Override
    public boolean hasNext() {
        while ((itr2 == null || !itr2.hasNext()) && itr1.hasNext()) {
            itr2 = itr1.next().iterator();
        }
        
        return itr2 != null && itr2.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

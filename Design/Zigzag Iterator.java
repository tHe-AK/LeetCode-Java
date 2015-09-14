public class ZigzagIterator {
    private List<Iterator<Integer>> rec;
    private int cur;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        rec = new ArrayList<Iterator<Integer>>();
        rec.add(v1.iterator());
        rec.add(v2.iterator());
        cur = 0;
    }

    public int next() {
        if (hasNext()) {
            int val = rec.get(cur).next();
            cur = (cur + 1) % rec.size();
            return val;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean hasNext() {
        if (rec.get(cur).hasNext()) {
            return true;
        }
        
        for (int i = cur + 1; i < rec.size(); i++) {
            if (rec.get(i).hasNext()) {
                cur = i;
                return true;
            }
        }
        
        for (int i = 0; i < cur; i++) {
            if (rec.get(i).hasNext()) {
                cur = i;
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

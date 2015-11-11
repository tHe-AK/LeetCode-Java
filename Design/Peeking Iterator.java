// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> it;
    
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if (iterator == null) {
	        throw new IllegalArgumentException();
	    }
	        
	    it = iterator;
	    
	    if (it.hasNext()) {
	        next = it.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
	@Override
	public Integer next() {
	    Integer cur = next;
	    next = it.hasNext() ? it.next() : null;
	    
	    return cur;
	}

    @Override
	public boolean hasNext() {
	    return next != null;
	}
}

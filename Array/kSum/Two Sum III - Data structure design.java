public class TwoSum {
    private HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();

	public void add(int number) {
	    if (rec.containsKey(number)) {
	        rec.put(number, rec.get(number) + 1);
	    }
	    else {
	        rec.put(number, 1);
	    }
	}

	public boolean find(int value) {
	    for (Integer key : rec.keySet()) {
	        int num = value - key;
	        
	        if (key == num) {
	            if (rec.get(key) >= 2) {
	                return true;
	            }
	        }
	        else {
	            if (rec.containsKey(num)) {
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}
}

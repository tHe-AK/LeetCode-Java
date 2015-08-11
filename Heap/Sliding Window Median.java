class Node {
	int id;
	int count;
	
	Node(int id, int count) {
		this.id = id;
		this.count = count;
	}
}


class HashHeap {
    HashMap<Integer, Node> hash;
    List<Integer> heap;
    int size;
    Comparator<Integer> comparator;
    
    HashHeap(String type) {
        hash = new HashMap<Integer, Node>();
        heap = new ArrayList<Integer>();
        size = 0;
        
        if (type.equals("max")) {
        	comparator = new Comparator<Integer>() {
	            public int compare(Integer a, Integer b) {
	                return b.compareTo(a);
	            }
        	};
        }
        else {
        	comparator = new Comparator<Integer>() {
	            public int compare(Integer a, Integer b) {
	                return a.compareTo(b);
	            }
        	};
        }
    }
    
    int size() {
        return size;
    }
    
    boolean empty() {
        return size == 0;
    }
    
    void offer(int val) {
    	if (hash.containsKey(val)) {
    		hash.get(val).count++;
    	}
    	else {
            int id = heap.size();
            heap.add(val);
            Node node = new Node(id, 1);
            hash.put(val, node);
            shiftUp(id);
    	}
    	
    	size++;
    }
    
    int poll() {
        if (empty()) {
            throw new RuntimeException("Heap is empty.");
        }
        
        int val = heap.get(0);
        remove(val);
        
        return val;
    }
    
    boolean remove(int val) {
        if (empty()) {
            throw new RuntimeException("Heap is empty.");
        }
        
        if (!hash.containsKey(val)) {
            return false;
        }
           
        Node node = hash.get(val);
        
        if (node.count > 1) {
        	node.count--;
        }
        else {
        	int id = node.id;
            heap.remove(id);
            hash.remove(val);
            
            if (id < heap.size()) {
                val = heap.remove(heap.size() - 1);
                heap.add(id, val);
                hash.get(val).id = id;
                shiftUp(id);
                shiftDown(id);
            }
        }
        
        size--;
        
        return true;
    }
    
    int peek() {
        if (empty()) {
            throw new RuntimeException("Heap is empty.");
        }
        
        return heap.get(0);
    }
    
    void shiftUp(int id) {
        int parent = (id - 1) / 2;
        
        while (id > 0 && comparator.compare(heap.get(parent), heap.get(id)) > 0) {
            swap(parent, id);
            id = parent;
            parent = (id - 1) / 2;
        }
    }
    
    void shiftDown(int id) {
        int leftChild = 2 * id + 1;
        int rightChild = 2 * id + 2;
        
        while (leftChild < heap.size()) {
            int child = (rightChild >= heap.size() || comparator.compare(heap.get(leftChild), heap.get(rightChild)) < 0) ? leftChild : rightChild;

            if (comparator.compare(heap.get(id), heap.get(child)) > 0) {
                swap(id, child);
                id = child;
                leftChild = 2 * id + 1;
                rightChild = 2 * id + 2;
            }
            else {
                break;
            }
        }
    }
    
    void swap(int id1, int id2) {
        Integer val1 = heap.get(id1);
        Integer val2 = heap.get(id2);
        heap.set(id1, val2);
        heap.set(id2, val1);
        hash.get(val1).id = id2;
        hash.get(val2).id = id1;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0 || k < 1) {
            return result;
        }
        
        HashHeap max = new HashHeap("max");
        HashHeap min = new HashHeap("min");
        
        for (int i = 0; i < nums.length; i++) {
            if (max.empty() || nums[i] <= max.peek()) {
                max.offer(nums[i]);
            }
            else {
                min.offer(nums[i]);
            }
            
            if (i >= k) {
                if (nums[i - k] <= max.peek()) {
                    max.remove(nums[i - k]);
                }
                else {
                	min.remove(nums[i - k]);
                }
            }
            
            while (max.size() < min.size()) {
                max.offer(min.poll());
            }
            
            while (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }

            if (i >= k - 1) {
            	result.add(max.peek());
            }
        }
        
        return result;
    }
}

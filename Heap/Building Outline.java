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
            int last = heap.size() - 1;
            swap(id, last);
            heap.remove(last);
            hash.remove(val);
            
            if (id < heap.size()) {
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

class Point {
    int x;
    int height;
    boolean isStart;
    
    public Point(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}

public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        
        ArrayList<Point> rec = new ArrayList<Point>();
        
        for (int[] building : buildings) {
            rec.add(new Point(building[0], building[2], true));
            rec.add(new Point(building[1], building[2], false));
        }
        
        Collections.sort(rec, new Comparator<Point>() {
            public int compare(Point point1, Point point2) {
                if (point1.x != point2.x) {
                    return point1.x - point2.x;
                }
                else if (point1.isStart && point2.isStart) {
                    return point2.height - point1.height;
                }
                else if (!point1.isStart && !point2.isStart) {
                    return point1.height - point2.height;
                }
                else {
                    return point1.isStart ? -1 : 1;
                }
            }
        });
        
        HashHeap heap = new HashHeap("max");
        Integer pre = null;
        
        for (Point point : rec) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            if (point.isStart) {
                if (heap.empty()) {
                    pre = point.x;
                }
                else if (point.height > heap.peek()) {
                    temp.add(pre);
                    temp.add(point.x);
                    temp.add(heap.peek());
                    result.add(temp);
                    pre = point.x;
                }
                
                heap.offer(point.height);
            }
            else {
                heap.remove(point.height);

                if (heap.empty()) {
                    temp.add(pre);
                    temp.add(point.x);
                    temp.add(point.height);
                    result.add(temp);
                    pre = null;
                }
                else if (point.height > heap.peek()) {
                    temp.add(pre);
                    temp.add(point.x);
                    temp.add(point.height);
                    result.add(temp);
                    pre = point.x;
                }
            }
        }
        
        return result;
    }
}

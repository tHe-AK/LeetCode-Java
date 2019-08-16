class TrieNode {
    private TrieNode[] links;
    private int count;
    private final int N = 27;
    
    public TrieNode() {
        links = new TrieNode[N];
        count = 0;
    }
    
    public boolean containsKey(char ch) {
        int idx = getIdx(ch);
        return links[idx] != null;
    }
    
    public TrieNode get(char ch) {
        int idx = getIdx(ch);
        return links[idx];
    }
    
    public void putIfAbsent(char ch) {
        int idx = getIdx(ch);
        
        if (links[idx] == null) {
            links[idx] = new TrieNode();
        }
    }
    
    private int getIdx(char ch) {
        return ch == ' ' ? N - 1 : ch - 'a';
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
}

class Pair {
    private String str;
    private int count;
    
    public Pair(String str, int count) {
        this.str = str;
        this.count = count;
    }
    
    public String getStr() {
        return str;
    }
    
    public int getCount() {
        return count;
    }
}

public class AutocompleteSystem {
    private TrieNode root;
    private TrieNode node;
    private String str;
    private final int N = 27;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        node = root;
        str = "";
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        
        if (c == '#') {
            insert(str, 1);
            node = root;
            str = "";
        } else {
            str += c;
            
            if (node != null) {
                if (node.containsKey(c)) {
                    node = node.get(c);

                    Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.getCount() != b.getCount() ? Integer.compare(b.getCount(), a.getCount()) : a.getStr().compareTo(b.getStr()));
                    search(node, str, pq);

                    for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                        res.add(pq.poll().getStr());
                    }
                } else {
                    node = null;
                }
            }
        }
        
        return res;
    }
    
    private void insert(String sentence, int time) {
        TrieNode node = root;
        
        for (char ch : sentence.toCharArray()) {
            node.putIfAbsent(ch);
            node = node.get(ch);
        }
        
        node.setCount(node.getCount() + time);
    }
    
    private void search(TrieNode node, String str, Queue<Pair> pq) {
        if (node == null) {
            return;
        }
        
        if (node.getCount() > 0) {
            pq.offer(new Pair(str, node.getCount()));
        }
        
        for (int i = 0; i < N; i++) {
            char ch = i < N - 1 ? (char) ('a' + i) : ' ';
            search(node.get(ch), str + ch, pq);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

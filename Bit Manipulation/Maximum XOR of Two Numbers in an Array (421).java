public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            
            for (int num : nums){
                set.add(num & mask);
            }
            
            int target = max | (1 << i);
            
            for (int prefix : set) {
                if (set.contains(prefix ^ target)) {
                    max = target;
                    break;
                }
            }
        }
        
        return max;
    }
}

class TrieNode {
    public TrieNode[] links;
    
    public TrieNode() {
        links = new TrieNode[2];
    }
}
    
public class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        
        for (int num: nums) {
            TrieNode node = root;
            
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                
                if (node.links[bit] == null) {
                    node.links[bit] = new TrieNode();
                }
                
                node = node.links[bit];
            }
        }
        
        int max = 0;
        
        for (int num: nums) {
            TrieNode node = root;
            int curr = 0;
            
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                
                if (node.links[bit ^ 1] != null) {
                    curr += (1 << i);
                    node = node.links[bit ^ 1];
                } else {
                    node = node.links[bit];
                }
            }
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}

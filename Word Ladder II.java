public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (start == null || end == null || dict == null || start.equals(end) == true || dict.size() < 2 || dict.contains(start) == false || dict.contains(end) == false) {
            return result;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
        queue.add(start);
        visited.add(start);
        boolean flag = false;
        
        while (queue.isEmpty() == false && flag == false) {
            int size = queue.size();
            HashSet<String> level = new HashSet<String>();

            for (int i = 0; i < size; i++) {
                String front = queue.remove();
                ArrayList<String> value = new ArrayList<String>();
                for (int j = 0; j < front.length(); j++) {
                    StringBuilder temp = new StringBuilder(front);
                    for (char k = 'a'; k <= 'z'; k++) {
                        temp.setCharAt(j, k);
                        String str = temp.toString();
                        if (visited.contains(str) == false && dict.contains(str) == true) {
                            value.add(str);
                            level.add(str);
                        }
                    }
                }
                hashMap.put(front, value);
            }
            
            for (String str : level) {
                if (str.equals(end) == true) {
                    flag = true;
                    break;
                }
                queue.add(str);
                visited.add(str);
            }
        }
        
        if (flag == false) {
            return result;
        }
        
        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
        helper(start, end, path, hashMap, result);
        
        return result;
    }
    
    private void helper(String start, String end, ArrayList<String> path, HashMap<String, ArrayList<String>> hashMap, ArrayList<ArrayList<String>> result) {
        if (start.equals(end) == true) {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        if (hashMap.containsKey(start) == false) {
            return;
        }
        
        for (String value : hashMap.get(start)) {
            path.add(value);
            helper(value, end, path, hashMap, result);
            path.remove(path.size() - 1);
        }
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        List<int[]> res = new LinkedList<>();
        
        for (int[] pair : people) {
            res.add(pair[1], pair);
        }
        
        return res.toArray(new int[0][]);
    }
}

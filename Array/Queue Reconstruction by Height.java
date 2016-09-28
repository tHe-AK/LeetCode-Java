public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        
        List<int[]> result = new LinkedList<int[]>();
        
        for (int[] pair : people) {
            result.add(pair[1], pair);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

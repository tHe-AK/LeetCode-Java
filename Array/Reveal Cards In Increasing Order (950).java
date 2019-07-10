class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        int[] res = new int[N];
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        
        for (int i = 0; i < N; i++) {
            res[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        
        return res;
    }
}

public class Twitter {
    private class Tweet {
        public int id;
        public int time;
        public Tweet next;
            
        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet head;
        
        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            head = null;
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unfollow(int id) {
            followed.remove(id);
        }
        
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweetMap.put(id, tweet);
            tweet.next = head;
            head = tweet;
        }
    }
    
    private Map<Integer, User> userMap;
    private Map<Integer, Tweet> tweetMap;
    private int timeStamp;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timeStamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        if(!userMap.containsKey(userId)) {
            return result;
        }
        
        Set<Integer> users = userMap.get(userId).followed;
        users.add(userId);
        Queue<Tweet> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        for (int user: users) {
            Tweet tweet = userMap.get(user).head;

            if (tweet != null) {
                queue.add(tweet);
            }
        }
        
        while (!queue.isEmpty() && result.size() < 10) {
            Tweet peek = queue.poll();
            result.add(peek.id);

            if (peek.next != null) {
                queue.add(peek.next);
            }
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

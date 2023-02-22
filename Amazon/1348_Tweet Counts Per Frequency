class TweetCounts {

    private Map<String, TreeMap<Integer, Integer>> map;
    
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        
        if (!map.containsKey(tweetName)) map.put(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        tweetMap.put(time, tweetMap.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
	
	    if (!map.containsKey(tweetName)) return null;
        List<Integer> res = new LinkedList<>();
        
        int interval = 0, size = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else {
            interval = 86400;
        }
        size = ((endTime - startTime) / interval) + 1;
        
        int[] buckets = new int[size];
        
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        
        for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {
            
            int index = (entry.getKey() - startTime) / interval;
            buckets[index] += entry.getValue();
        }
        
        for (int num : buckets) res.add(num);
        
        return res;
    }
}

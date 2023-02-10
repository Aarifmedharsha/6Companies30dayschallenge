class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            freq.put(words[i],freq.getOrDefault(words[i],0)+1);
        }
        List<String> res = new ArrayList(freq.keySet());
        Collections.sort(res, (w1, w2) -> freq.get(w1).equals(freq.get(w2)) ?w1.compareTo(w2) : freq.get(w2) - freq.get(w1));
       return res.subList(0, k);
    }
}
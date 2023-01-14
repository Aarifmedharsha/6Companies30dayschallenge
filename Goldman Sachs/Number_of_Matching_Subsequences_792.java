class Solution {
    public boolean helper(String s,String sub){
        int i=0;
        int j=0;
        int n=s.length();
        int m=sub.length();
        while(i<m && j<n){
            if(sub.charAt(i)==s.charAt(j)) i++;
            j++;
        }
        return i==m;
    }
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        Map<String,Integer> mp=new HashMap<>();
        for(String i:words) mp.put(i,mp.getOrDefault(i,0)+1);
        for(String i:mp.keySet()) if(helper(s,i)) count+=mp.get(i);
        return count;
    }
}

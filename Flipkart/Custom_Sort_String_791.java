class Solution {
    public String customSortString(String order, String s) {
        boolean[] vis = new boolean[26];
        int[] cnt = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            vis[s.charAt(i) - 'a'] = true;
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < order.length(); i++){
            if(vis[order.charAt(i) - 'a']){
                while(cnt[order.charAt(i) - 'a']-- > 0)
                    res.append(order.charAt(i));
                vis[order.charAt(i) - 'a'] = false;
            }
        }
        for(char c = 'a' ; c <= 'z' ; c++){
            if(vis[c - 'a']) {
                while(cnt[c - 'a']-- > 0)
                    res.append(c);                
            }
        }
        return res.toString();
    }
}
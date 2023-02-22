class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, 0, s);
    }
    
    private int dfs(Set<String> set, int idx, String s) {
        if (idx >= s.length()) return 0;
        int res = -1;  // did not find method to split;
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (!set.add(sub)) continue; //already contains sub
            int next = dfs(set, i, s);
            if (next >= 0) res = Math.max(res, next + 1);
            set.remove(sub);
        }
        return res;
    }
}

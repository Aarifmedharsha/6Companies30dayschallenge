class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int res = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; ++i)
            res = Math.max(res, special[i] - special[i - 1] - 1);
        return res;
    }
}
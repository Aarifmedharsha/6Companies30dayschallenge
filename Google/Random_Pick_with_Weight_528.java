class Solution {

    private int totalSum;
    private int[] prefixSum;
    
    public Solution(int[] w) {
        int sum = 0;
        prefixSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
        totalSum = sum;
    }
    
    public int pickIndex() {
        double target = totalSum * Math.random();
        int left = 0, right = prefixSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > prefixSum[mid]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
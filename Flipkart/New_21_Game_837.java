class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0){
            return 1;
        }

        double[] dp = new double[k + maxPts];
        double sum = 1;
        dp[0] = 1;
        for (int i = 1; i < k + maxPts; i++){
            dp[i] = sum / maxPts;
            if (i >= maxPts){
                sum -= dp[i - maxPts];
            }
            if (i < k){
                sum += dp[i];
            }
        }

        double ans = 0;
        for (int i = k; i < k + maxPts && i <= n; i++){
            ans += dp[i];
        }

        return ans;
    }
}
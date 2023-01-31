class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        long mod=(long)1e9+7;
        long sharsec=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            long sec=0;
            long forg=0;
            if(i-delay>=0) sec=dp[i-delay];
            if(i-forget>=0) forg=dp[i-forget];
            sharsec+=(sec-forg + mod) % mod;
            dp[i] = sharsec;
        } 
        long ans = 0;
        for(int i=n-forget + 1 ; i <= n; i++){
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
        }
    }

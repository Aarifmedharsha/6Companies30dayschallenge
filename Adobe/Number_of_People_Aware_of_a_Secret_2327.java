class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long fresh [] = new long[n + 1];
        long active [] = new long[n + 1];
        long total [] = new long[n + 1];
        long mod = 1000000007;

        fresh[1] = 1;
        total[1] = 1;
        for(int i = 2; i <= n ; i++) {
            active[i] = (active[i] % mod + active[i-1] % mod) % mod;

if(i - forget >= 0) active[i] = (active[i] - fresh[i-forget] + mod) % mod;

if(i - delay >= 0) active[i] = (active[i] + fresh[i-delay]) % mod ;

            fresh[i] = (fresh[i] + active[i]) % mod;
            total[i] = (total[i-1] + fresh[i] )% mod ;

if(i - forget >= 0) total[i] = (total[i] - fresh[i-forget] + mod) %  mod;
        }
        return (int)(total[n] % mod);
    }
}
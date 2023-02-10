class Solution {
    public static int helper(int n){
        int[] dp= new int[33];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<33;i++){
            dp[i]=dp[i-1]+dp[i-2]+(int)Math.pow(2,i-2);
        }
        double pow = Math.log(n)/Math.log(2);
        if(pow==(int)pow){
            return dp[(int)pow];
        }
        pow=Math.floor(pow);
        int res=dp[(int)pow];
        int low=(int)Math.pow(2,pow);
        int remain=n-low;
        if(remain>=low/2){
            res+=dp[(int)pow-1]+(remain-low/2+1);
        }
        else{
            res+=helper(remain);
        }
        return res;
    }
    public int findIntegers(int n) {
        int count=helper(n);
        return n-count+1;
}
}
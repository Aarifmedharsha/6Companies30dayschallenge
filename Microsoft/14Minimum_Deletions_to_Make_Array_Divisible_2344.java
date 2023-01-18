class Solution {
    public static int gcd(int a,int b){
            if(b==0) return a;
            return gcd(b,a%b);
        }
        public static int gcdofarray(int []arr){
            int temp =arr[0];
            for(int i:arr){
                temp =gcd(i, temp);
            }
            return temp;
        }
    public int minOperations(int[] nums, int[] numsDivide) {
        int count=0;
        int g =gcdofarray(numsDivide);
        Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(g%nums[i]==0) return count;
                else count++;
            }
            return -1;
    }
}

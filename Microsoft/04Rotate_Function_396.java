class Solution {
    public int maxRotateFunction(int[] nums) {
        int temp=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            temp+=i*nums[i];
            sum+=nums[i];
        }
        int max=temp;
        for(int i=nums.length-1;i>=1;i--){
            temp+=sum-(nums.length*nums[i]);
            max=Math.max(max,temp);
        }
        return max;
    }
}

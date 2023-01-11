class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int temp [] = nums.clone();
        Arrays.sort(temp);
        int start =0;
        int end=nums.length-1;
        for(int i=start;i<nums.length;i++){
            if(nums[i]==temp[i]) start++;
            else break;
        }
        for(int i=end;i>=0;i--){
            if(nums[i]==temp[i]) end--;
            else break;
        }
        if(end-start+1>0) {
            return end-start+1;
        }
        else return 0;
    }
}

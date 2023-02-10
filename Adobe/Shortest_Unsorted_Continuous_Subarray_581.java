class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        //arr=nums;
        Arrays.sort(arr);
        int a=0;
        int b=0;
        int l=nums.length;
        for(int i=0;i<l;i++){
            if(!(nums[i]==arr[i])){
                a=i;
                break;
            }
        }
    
        for(int i=nums.length-1;i>=0;i--){
            if(!(nums[i]==arr[i])){
                b=i;
                break;
            }
        }
        int c=0;
        if(a==b){
            c=0;
        }
        else{
         c=(b-a)+1;
        }
        return c;
        
    }
}
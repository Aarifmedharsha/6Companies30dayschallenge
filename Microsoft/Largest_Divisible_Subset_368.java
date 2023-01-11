class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int arr[] = new int[nums.length];
        return lds(nums,arr,ldssize(nums,arr)); 
    }
    public int ldssize(int [] nums , int[] arr){
        Arrays.sort(nums);
        Arrays.fill(arr,1);
        int lds1=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    arr[i]=Math.max(arr[i],arr[j]+1);
                    lds1=Math.max(lds1,arr[i]);
                }
            }
        }
        return lds1;
    }
    public List<Integer> lds(int[] nums,int[] arr,int lds1){
        int prev=-1;
        var list1 = new LinkedList<Integer>();
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]==lds1 &&(prev==-1 ||prev%nums[i]==0)){
                list1.addFirst(nums[i]);
                lds1--;
                prev=nums[i];
            }
        }
        return list1;
    }
}

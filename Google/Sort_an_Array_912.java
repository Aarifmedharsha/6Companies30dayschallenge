class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        int mid=nums.length/2;
        int[] left=sortArray(Arrays.copyOfRange(nums,0,mid));
        int[] right=sortArray(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }
    static int[] merge(int[] first,int[] last){
        int[] mix=new int[first.length+last.length];
        int i=0,j=0,k=0;
        while(i<first.length && j<last.length){
            if(first[i]<last[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=last[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<last.length){
            mix[k]=last[j];
            j++;
            k++;
        }
        return mix;
    } 
}
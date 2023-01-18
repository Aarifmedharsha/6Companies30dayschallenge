class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        HashMap<Integer,Integer> ex=new HashMap<>();
        for(int i:nums) ex.put(i,ex.getOrDefault(i,0)+1);
        for(int i=0;i<nums.length;i++){
            if(ex.get(nums[i])==0) continue;
            else if(mp.getOrDefault(nums[i],0)>0){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                mp.put(nums[i]+1,mp.getOrDefault(nums[i]+1,0)+1);
                ex.put(nums[i],ex.getOrDefault(nums[i],0)-1);
            }
            else if(ex.getOrDefault(nums[i]+1,0)>0&&ex.getOrDefault(nums[i]+2,0)>0){
                ex.put(nums[i],ex.getOrDefault(nums[i],0)-1);
                ex.put(nums[i]+1,ex.getOrDefault(nums[i]+1,0)-1);
                ex.put(nums[i]+2,ex.getOrDefault(nums[i]+2,0)-1);
                mp.put(nums[i]+3,mp.getOrDefault(nums[i]+3,0)+1);
            }
            else return false;
        }
        return true;
    }
}

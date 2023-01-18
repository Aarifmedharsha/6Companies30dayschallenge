class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        long count=0;
        for(int i=0;i<nums.length;i++){
            StringBuilder sb=new StringBuilder(String.valueOf(nums[i]));
            sb.reverse();
            int rev=Integer.parseInt(sb.toString());
            if(map.containsKey(nums[i]-rev)){
                count+=map.get(nums[i]-rev);
                map.put(nums[i]-rev,map.get(nums[i]-rev)+1);
            }
            else{
                map.put(nums[i]-rev,1);
            }
        }
        return (int)(count%1000000007);
    }
}

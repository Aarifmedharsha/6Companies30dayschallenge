class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int count = 0;
     
        Set<String> s = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
              StringBuilder subarray = new StringBuilder();
                count = 0;
             for(int j = i; j<nums.length; j++){
                subarray.append(nums[j] + ",");
                 if(nums[j] % p == 0 )
                     count++;
                 if(count <= k)
                     s.add(subarray.toString());
             
             }
       
        }
        return s.size();
    }
}
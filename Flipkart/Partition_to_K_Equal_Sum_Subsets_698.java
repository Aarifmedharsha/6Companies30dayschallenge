class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean [] seen = new boolean[nums.length];
        int max = nums[0], sum = 0, weight = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        weight = sum / k;
        if (sum % k != 0 || max > weight) return false;
        return dfs(nums, seen, k, weight, weight, 0, 0);
    }

    public boolean dfs(int[] nums, boolean[] seen, int k, int weight, int originWeight, int visited, int index){
        if (weight == 0 && k != 0) {
            weight = --k == 0 ? 0 : originWeight;
            index = 0;
        }
        if (visited == nums.length) return !(weight != 0 || k != 0);
        for(int i = index; i < nums.length; ++i)
            if (!seen[i] && nums[i] <= weight) {
                seen[i] = true;
                if (dfs(nums, seen, k, weight - nums[i], originWeight, visited + 1, i + 1)) return true;
                seen[i] = false;
            }
        return false;
    }
}
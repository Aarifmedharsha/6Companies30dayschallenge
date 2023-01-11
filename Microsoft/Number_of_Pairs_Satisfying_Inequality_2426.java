class Solution{
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int offset = 30_000; 
        int size = 2 * 3 * 10_000 + 1 + 1;
        int[] tree = new int[size]; 
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums2[i] = nums1[i] - nums2[i] + offset;
            res += queryBIT(nums2[i] + diff + 1, tree);
            updateBIT(nums2[i], tree, size);
        }
        return res;
    }
    private int lsb(int i) {
        return i&(-i);
    }
    private int queryBIT(int i, int[] tree) {
        int sum = 0;
        for(; i >= 1; i -= lsb(i)) sum += tree[i];
        return sum;
    }
    private void updateBIT(int i, int[] tree, int size){
        i++;
        for(; i < size; i += lsb(i)) tree[i]++;
    }
}

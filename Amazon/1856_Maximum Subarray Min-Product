class Solution {
    long[] preSum;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left_bound = new int[n], right_bound = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (!st.isEmpty())
                left_bound[i] = st.peek() + 1;
            else
                left_bound[i] = 0;
            st.add(i);
        }
        st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (!st.isEmpty())
                right_bound[i] = st.peek() - 1;
            else
                right_bound[i] = n - 1;
            st.add(i);
        }
        preSum = new long[n+1];
        for (int i = 0; i < n; ++i) preSum[i + 1] = preSum[i] + nums[i];
        long maxProduct = 0;
        for (int i = 0; i < n; ++i)
            maxProduct = Math.max(maxProduct, getSum(left_bound[i], right_bound[i]) * nums[i]);
        return (int) (maxProduct % 1000_000_007);
    }
    long getSum(int left, int right) { // left, right inclusive
        return preSum[right + 1] - preSum[left];
    }
}

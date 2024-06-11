class Solution {
    // 动态规划
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(x + pre, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
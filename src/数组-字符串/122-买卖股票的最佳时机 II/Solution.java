public class Solution {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 9, 3, 4, 67, 344, 6, 5 };
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

}

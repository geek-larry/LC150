public class Solution {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 9, 3, 4, 67, 344, 6, 5 };
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

}

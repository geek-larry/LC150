public class Solution {

    // 一次遍历
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = { 4, 7, 8, 1, 9, 45 };
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

}

package arrays;

/**
* <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Problem</a>
**/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int ans = 0;
        for (int price : prices) {
            if (price < buyingPrice) buyingPrice = price;
            else ans = Math.max(ans, price - buyingPrice);
        }
        return ans;
    }
}

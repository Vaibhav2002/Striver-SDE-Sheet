package greedy;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website">Problem</a>
 **/
public class MinimumCoins {
    private static final int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};

    public static int findMinimumCoins(int amount) {
        int count = 0, coinIndex = 0;
        while (amount > 0 && coinIndex < coins.length) {
            if (coins[coinIndex] <= amount) {
                count += amount / coins[coinIndex];
                amount = amount % coins[coinIndex];
            }
            coinIndex++;
        }
        return count;
    }
}

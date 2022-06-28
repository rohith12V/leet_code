package Day_7_Array;

public class Lec_121_Best_Time_to_buy_Sell {
  public static void main(String[] args) {
    new Lec_121_Best_Time_to_buy_Sell().maxProfit(
            new int[]{7,1,5,3,6,4}
    );
  }

  public int maxProfit(int[] prices) {
    // keep track of max profit
    int maxProfitFoundSoFar = 0;
    int currentMinimum = prices[0];
    int currentMaximum = prices[0];

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < currentMinimum) {
        currentMinimum = prices[i];
        currentMaximum = prices[i];
      }
      else if (prices[i] > currentMaximum) {
        currentMaximum = prices[i];
      }
      maxProfitFoundSoFar = Math.max(maxProfitFoundSoFar, currentMaximum - currentMinimum);
    }
    return maxProfitFoundSoFar;
  }
}

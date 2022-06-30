package dynamic_programming;

public class Lec_746_Min_Cost_Climbing_Stairs {
  public static void main(String[] args) {
    int cost =
        new Lec_746_Min_Cost_Climbing_Stairs()
            .minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    System.out.println(cost);

    int cost2 =
        new Lec_746_Min_Cost_Climbing_Stairs().minCostClimbingStairs(new int[] {10, 15, 20});
    System.out.println(cost2);

    int cost3 =
        new Lec_746_Min_Cost_Climbing_Stairs()
            .minCostClimbingStairs(
                new int[] {
                  1, 2, 3, 4, 5, 6, 7, 8, 12, 1, 1, 1, 1, 2, 3, 1, 1, 3, 4, 5, 6, 7, 2, 3, 1, 1, 1,
                  1, 7
                });
    System.out.println(cost3);
  }

  public int minCostClimbingStairs(int[] cost) {

    // without using cache
    int lResult = minCostClimbingStairsUtilWithoutCache(cost, 0, 0, cost.length);
    int RResult = minCostClimbingStairsUtilWithoutCache(cost, 0, 1, cost.length);
    //    return Math.min(lResult, RResult);

    // with using cache
//    minCostClimbingStairsUtilWithCache(cost, cost.length - 1, cost.length);
    return Math.min(cost[0], cost[1]);
  }

  private int minCostClimbingStairsUtilWithoutCache(
      int[] cost, int currentCost, int currentStep, int targetStep) {
    if (currentStep > targetStep) return Integer.MAX_VALUE;
    if (currentStep == targetStep) return currentCost;

    return Math.min(
        minCostClimbingStairsUtilWithoutCache(
            cost, currentCost + cost[currentStep], currentStep + 1, targetStep),
        minCostClimbingStairsUtilWithoutCache(
            cost, currentCost + cost[currentStep], currentStep + 2, targetStep));
  }

}

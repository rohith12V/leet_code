package dynamic_programming;

public class Lec_746_Min_Cost_Climbing_Stairs {
  public static void main(String[] args) {
    int cost =
        new Lec_746_Min_Cost_Climbing_Stairs()
            .minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    System.out.println(cost);
  }

  public int minCostClimbingStairs(int[] cost) {
    int startIndex = cost.length - 1;
    int length = cost.length;

    if (startIndex + 1 > length) {}

    return -1;
  }
}

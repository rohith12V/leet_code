package Day_5_Arrays;

import java.util.Arrays;

public class Lec53_Maximum_SubArray {
  public static void main(String[] args) {
    for (int[] ints :
        Arrays.asList(
            new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            new int[] {1},
            new int[] {5, 4, -1, 7, 8},
            new int[] {-2, -3, 4, -1, -2, 1, 5, -3})) {
      System.out.println(new Lec53_Maximum_SubArray().maxSubArray(ints));
    }
  }

  // Using Kadane's Algorithm
  // idea - we carry currentSum as long as it is > 0
  // once it is < 0 we make currentSum = 0
  public int maxSubArray(int[] nums) {
    int currentSum = 0;
    int maximumSumFoundSoFar = nums[0];
    for (int num : nums) {
      currentSum += num;
      maximumSumFoundSoFar = Math.max(maximumSumFoundSoFar, currentSum);
      if (currentSum < 0) {
        currentSum = 0;
      }
    }
    return maximumSumFoundSoFar;
  }
}

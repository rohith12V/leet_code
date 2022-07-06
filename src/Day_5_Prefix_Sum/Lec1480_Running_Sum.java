package Day_5_Prefix_Sum;

import java.util.Arrays;

public class Lec1480_Running_Sum {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new Lec1480_Running_Sum().runningSum(new int[] {1, 2, 3, 4})));
    System.out.println(
        Arrays.toString(new Lec1480_Running_Sum().runningSum(new int[] {1, 1, 1, 1, 1})));
  }

  public int[] runningSum(int[] nums) {
    int index = 0;
    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }
    return nums;
  }
}

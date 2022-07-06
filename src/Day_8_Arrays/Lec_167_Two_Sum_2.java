package Day_8_Arrays;

import java.util.Arrays;

public class Lec_167_Two_Sum_2 {
  public static void main(String[] args) {
    int[] ints = new Lec_167_Two_Sum_2().twoSum(new int[] {2, 7, 11, 15}, 18);
    System.out.println(Arrays.toString(ints));
  }

  public int[] twoSum(int[] numbers, int target) {
    int low = 0;
    int high = numbers.length - 1;

    while (low < high) {
      if (numbers[low] + numbers[high] == target) {
        return new int[] {low, high};
      }
      while (numbers[low] + numbers[high] > target) {
        high--;
      }
      while (numbers[low] + numbers[high] < target) {
        low++;
      }
    }
    return new int[] {};
  }
}

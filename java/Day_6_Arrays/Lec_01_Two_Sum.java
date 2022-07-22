package Day_6_Arrays;

import java.util.HashMap;

public class Lec_01_Two_Sum {
  public static void main(String[] args) {}

  // Idea is to search for the remaining part in hashMap. if found return indexes
  public int[] twoSum(int[] nums, int target) {
    final HashMap<Integer, Integer> hashSet = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      // calculate the remaining part which can add up to target
      // a + b = target
      // b = target - a
      int remaining = target - nums[i];

      // if we see b already return
      if (hashSet.containsKey(remaining)) {
        return new int[] {hashSet.get(remaining), i};
      }
      // if we don't see b. put current element in visited array
      hashSet.put(nums[i], i);
    }
    return new int[] {};
  }
}

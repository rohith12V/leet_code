/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that
 * single one.
 *
 * <p>You must implement a solution with a linear runtime complexity and use only constant extra
 * space.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [2,2,1] Output: 1
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [4,1,2,1,2] Output: 4
 *
 * <p>Example 3:
 *
 * <p>Input: nums = [1] Output: 1
 */
public class Lec136_Single_Number {
  public static void main(String[] args) {
    /**
     * Approach - if same elements are present even number of times we can cancel each other by X OR
     * between them.
     *
     * <p>so, if there is 1 unique element xor between all the elements will leave that unique
     * element alone.
     *
     * <p>0 ^ 0 = 0 1 ^ 1 = 0
     *
     * <p>0 ^ 1 = 1 1 ^ 0 = 1
     */
    int[] nums = new int[] {2, 2, 7};
    int resultSoFar = nums[0];
    for (int i = 1; i < nums.length; i++) {
      resultSoFar = resultSoFar ^ nums[i];
    }
    System.out.println(resultSoFar);
  }
}

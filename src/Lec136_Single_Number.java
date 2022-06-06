
/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */
public class Lec136_Single_Number {
    public static void main(String[] args) {
        /**
         * Approach -
         * if same elements are present even number of times we can cancel each other by X OR between them.
         *
         * so, if there is 1 unique element xor between all the elements will leave that unique element alone.
         *
         * 0 ^ 0 = 0
         * 1 ^ 1 = 0
         *
         * 0 ^ 1 = 1
         * 1 ^ 0 = 1
         */

        int[] nums = new int[]{2,2,7};
        int resultSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resultSoFar = resultSoFar ^ nums[i];
        }
        System.out.println(resultSoFar);
    }
}

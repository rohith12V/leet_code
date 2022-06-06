/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 5 * 104
 *     -109 <= nums[i] <= 109
 */

public class Lec169_Majority_Element {

    public static int majorityElement(int[] nums) {
        /**
         * Approach -
         *  if there exists a majority element in the array
         *  there should be atleast 1 element remaining if any 2 elements cancel out each other
         */
        int majorityElementFoundSoFar = nums[0];
        int majorityElementCount = 1;

        for (int i = 1; i < nums.length; i++) {
            // if next element is same count++
            if (majorityElementFoundSoFar == nums[i]) {
                majorityElementCount++;
            }
            // if next element is different this cancels out 1 of its prev element (i.e decrement majority count by 1 )
            if(majorityElementFoundSoFar != nums[i]){
                majorityElementCount--;
            }

            // if majority element Count is < 0 that indicates till this point in the array elements cancelled out each other and there is no majority element
            // mark current element as majority and continue the process
            if(majorityElementCount < 0) {
                majorityElementFoundSoFar = nums[i];
                majorityElementCount = 1;
            }
        }
        return majorityElementFoundSoFar;
    }
    public static void main(String[] args) {
        majorityElement(new int[]{3,2,3});
        majorityElement(new int[]{2,2,1,1,1,2,2});
        majorityElement(new int[]{2});
        majorityElement(new int[]{2,2,2});

    }
}

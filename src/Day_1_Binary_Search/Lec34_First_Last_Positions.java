package Day_1_Binary_Search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * important points to take away :
 *      Tweaking BST to find left most value and right most matching value
 *      case - 1 ( normal algorithm )
 *          if key is found return the index
 *
 *      case 2 ( tweaked version )
 *          to make bst get the left most index
 *                  when we find the element at mid then shift the right pointer to mid - 1;  [ start -> mid -1 ] ( new search )
 *          to make bst get the right most index
 *                  when we find the element at mid then shift the left pointer to mid + 1;  [ mid+1 -> end ] ( new search )
 *  *
 */
public class Lec34_First_Last_Positions {
    public static void main(String[] args) {
        final Lec34_First_Last_Positions ob = new Lec34_First_Last_Positions();
        System.out.println(Arrays.toString(ob.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(ob.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(ob.searchRange(new int[]{1}, 6)));
        System.out.println(Arrays.toString(ob.searchRange(new int[]{1}, 1)));
    }

    /**
     * O(n) approach
     */
    public int[] searchRangeUsingLinearTime(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        // base condition
        while (start < nums.length -1 && nums[start] < target){
            start++;
        }
        while (end > 0 && nums[end] > target) {
            end--;
        }
        if(start <= nums.length -1 && end >=0 && nums[start] == target && nums[end] == target) {
            return new int[] {start, end};
        }
        return new int[] {-1,-1};
    }

    public int[] searchRange(int[] nums, int target) {
        int lefIndex = searchRangeUsingBST(nums, target, true);
        int rightIndex = searchRangeUsingBST(nums, target, false);
        return new int[]{lefIndex, rightIndex};
    }

    /**
     * O(Log(n)) Approach
     */
    public int searchRangeUsingBST(int[] nums, int target, boolean leftBias) {
        int start = 0;
        int end = nums.length - 1 ;
        int index = -1;
        // base condition ( start should be less than or equal to end )
        while (start <= end) {
            // calculate middle point
            int mid = (start + end) / 2;
            // if middle element is greater than target i.e. our target lies in the first half
            if (nums[mid] > target) {
                end = mid - 1;
            }
            // if middle element is less than target i.e. our target lies in the second half
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                // if middle element is == target then modify the matching index;
                index = mid;
                // *** instead of exiting the algorithm we make new search based on bias element
                if (leftBias) {
                    // if its left biased we have to make sure end will always shift its position towards start [ start , mid - 1 ]
                    end = mid - 1;
                }
                else {
                    // *** if its right biased we have to make sure start will always shift its position towards end [ mid + 1 , end ]
                    start = mid + 1;
                }
            }
        }
        // return index
        return index;
    }
}

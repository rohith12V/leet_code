/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

/**
 * This Method is used to find a point in the array where we find non-increasing sequence ( rotated point )
 *  eg : 4,5,6,7,0,1,2 [ pivot_point = 3 ] [ index 0 -> 3 is sorted and index 4 -> 6 is sorted ]
 *  By using this pivot point we will come to know that start -> pivot will be sorted and pivot + 1 -> end will be sorted
 *  BST ( start , pivot )
 *  BST ( pivot + 1, end )
 */
public class Lec33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int rotatedIndex = findPivotIndex(nums);
        // check left side
        int index = performBST(nums, 0 , rotatedIndex  , target);
        if (index == -1) {
            // if we fail to find in the left part check in the right part-
            return performBST(nums, rotatedIndex + 1 , nums.length - 1, target);
        }
        return index;
    }

    private int performBST(int[] nums, int start, int end, int target) {
        // base case
        if (start <= end) {
            int mid = ( start + end ) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return performBST(nums, start, mid - 1, target);
            }
            else if (nums[mid] < target) {
                return performBST(nums, mid + 1, end, target);
            }
        }
        return  -1;
    }
    private int findPivotIndex(final int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        final Lec33_Search_in_Rotated_Sorted_Array obj = new Lec33_Search_in_Rotated_Sorted_Array();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 2));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 4));
    }
}

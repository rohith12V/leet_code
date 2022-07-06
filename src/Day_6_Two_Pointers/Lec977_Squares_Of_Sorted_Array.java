// package Day_6_Two_Pointers;
//
// public class Lec977_Squares_Of_Sorted_Array {
//  public static void main(String[] args) {
//    new Lec977_Squares_Of_Sorted_Array().sortedSquares(new int[]{
//         -5, -3, -2, -1
//    });
//  }
//
//  public int[] sortedSquares(int[] nums) {
//    int high = nums.length - 1;
//    int ptr = findFirstPositiveElement(nums);
//    int low = 0;
//
//
//  }
//
//  private int findFirstPositiveElement(int[] nums) {
//    for (int i = 0; i < nums.length; i++) {
//      if (nums[i] > 0) {
//        return i;
//      }
//    }
//    return nums.length -1;
//  }
//
//  private void swap(int[] nums, int low, int high) {
//    int temp = nums[low];
//    nums[low] = nums[high];
//    nums[high] = temp;
//  }
// }

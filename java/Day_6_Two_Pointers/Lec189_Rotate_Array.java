package Day_6_Two_Pointers;

public class Lec189_Rotate_Array {
  public static void main(String[] args) {
    new Lec189_Rotate_Array().rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 30879083);
  }

  public void rotate(int[] nums, int k) {

    int finalRotations = (k % (nums.length)); // 1,2,3,4,5,6,7

    reverse(nums, 0, nums.length - finalRotations - 1); // 4,3,2,1,5,6,7

    reverse(nums, nums.length - finalRotations, nums.length - 1); // 4,3,2,1,7,6,5

    reverse(nums, 0, nums.length - 1); // 5,6,7,1,2,3,4
  }

  private void reverse(int[] nums, int low, int high) {
    while (low <= high) {
      swap(nums, low, high);
      low++;
      high--;
    }
  }

  private void swap(int[] nums, int low, int high) {
    int temp = nums[low];
    nums[low] = nums[high];
    nums[high] = temp;
  }
}

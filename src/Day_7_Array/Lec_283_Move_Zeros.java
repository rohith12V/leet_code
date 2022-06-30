package Day_7_Array;

import java.util.Arrays;

public class Lec_283_Move_Zeros {
  public static void main(String[] args) {
    new Lec_283_Move_Zeros().moveZeroes(new int[] {0, 1});
      new Lec_283_Move_Zeros().moveZeroes(new int[] {1,2});
      new Lec_283_Move_Zeros().moveZeroes(new int[] {1,0,2});
      new Lec_283_Move_Zeros().moveZeroes(new int[] {1,9,0,2});
      new Lec_283_Move_Zeros().moveZeroes(new int[] {0,1,0,3,12});
  }

  public void moveZeroes(int[] nums) {
    int lowPointer = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i]  != 0) {
            swap(nums, i ,lowPointer++);
        }

    }
    System.out.println(Arrays.toString(nums));
  }

  private void swap(int[] nums, int tPointer, int currentPtr) {
    int temp = nums[tPointer];
    nums[tPointer] = nums[currentPtr];
    nums[currentPtr] = temp;
  }
}

package Day_7_Array;

import java.util.Arrays;

public class Lec_283_Move_Zeros {
  public static void main(String[] args) {
      new Lec_283_Move_Zeros().moveZeroes(new int[]{
             0,1
      });
  }
    public void moveZeroes(int[] nums) {
      int currentPtr = 0;
      int tPointer = -1;
      while (currentPtr < nums.length && tPointer < nums.length) {
          if (nums[currentPtr] == 0) {
              tPointer = currentPtr;
          }
          if (tPointer!=-1) {
              swap(nums, tPointer, currentPtr);
          }
          currentPtr++;
      }
    System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int tPointer, int currentPtr) {
      int temp = nums[tPointer];
      nums[tPointer] = nums[currentPtr];
      nums[currentPtr] = temp;
    }
}

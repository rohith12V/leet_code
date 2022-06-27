package Day_5_Binary_Search;

public class Lec35_Search_Insert_Positions {
    public int searchInsert(int[] nums, int target) {
        // traverse from 0 to length but
        // so that we can cover edge case where target is > last element
        return searchInsertUtil(nums, 0 , nums.length , target);
    }

    private int searchInsertUtil(int[] nums, int low, int high, int target) {
        if (low < high) {
           int mid = (low + high) / 2;
           if (nums[mid] == target) {
               return mid;
           }
           if (nums[mid] > target) {
               return searchInsertUtil(nums, low, mid, target);
           }
           if (nums[mid] < target) {
               return searchInsertUtil(nums, mid  + 1, high, target);
           }
        }
        // return current low pointer because this is where BST could not find the target and expected to be present at this index
        return low;
    }

  public static void main(String[] args) {
      int result = new Lec35_Search_Insert_Positions()
              .searchInsert(
                      new int[]{},
                      10
              );
    System.out.println(result);
  }
}

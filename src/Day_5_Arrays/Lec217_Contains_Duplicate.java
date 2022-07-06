package Day_5_Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Lec217_Contains_Duplicate {
  public static void main(String[] args) {
    System.out.println(new Lec217_Contains_Duplicate().containsDuplicateV1(new int[] {1, 2, 3, 1}));
    System.out.println(new Lec217_Contains_Duplicate().containsDuplicateV2(new int[] {1, 2, 3, 1}));

    System.out.println(new Lec217_Contains_Duplicate().containsDuplicateV1(new int[] {1, 2, 3, 4}));
    System.out.println(new Lec217_Contains_Duplicate().containsDuplicateV2(new int[] {1, 2, 3, 4}));

    System.out.println(
        new Lec217_Contains_Duplicate()
            .containsDuplicateV1(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    System.out.println(
        new Lec217_Contains_Duplicate()
            .containsDuplicateV2(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
  }

  // Space - O(1)
  // time - O(n) + O(n logn) ( sort )
  public boolean containsDuplicateV1(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      // if adjacent element matches that indicates a duplicate
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  // Space - O(n)
  // time - O(n)
  public boolean containsDuplicateV2(int[] nums) {
    final HashSet<Integer> frequency = new HashSet<>();
    for (int num : nums) {
      // if hashset already has the current element that indicates a duplicate
      if (frequency.contains(num)) {
        return true;
      }
      frequency.add(num);
    }
    return false;
  }
}

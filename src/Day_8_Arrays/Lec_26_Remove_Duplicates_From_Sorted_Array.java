package Day_8_Arrays;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Lec_26_Remove_Duplicates_From_Sorted_Array {
  public int removeDuplicates(int[] nums) {
    final HashSet<Integer> result = new LinkedHashSet<>();
    for (int num : nums) {
      result.add(num);
    }
    int length = result.size();
    int i = 0;
    for (Integer integer : result) {
      nums[i++] = integer;
    }
    return result.size();
  }

  public static void main(String[] args) {
    //
  }
}

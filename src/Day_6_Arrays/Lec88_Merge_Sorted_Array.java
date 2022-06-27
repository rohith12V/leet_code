package Day_6_Arrays;

import java.util.Arrays;

public class Lec88_Merge_Sorted_Array {
  public static void main(String[] args) {
    new Lec88_Merge_Sorted_Array()
        .merge(new int[] {4, 0, 0, 0, 0, 0}, 1, new int[] {1, 2, 3, 5, 6}, 5);
    new Lec88_Merge_Sorted_Array()
            .merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
    new Lec88_Merge_Sorted_Array()
            .merge(new int[] {1}, 1, new int[] {}, 0);
    new Lec88_Merge_Sorted_Array()
            .merge(new int[] {0}, 0, new int[] {1}, 1);
    new Lec88_Merge_Sorted_Array()
            .merge(new int[] {6,0,0,0}, 1, new int[] {1,1,3}, 3);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int aIndex = m - 1;
    int bIndex = n - 1;
    int cIndex = nums1.length - 1;

    // replace from the last
    while (aIndex >= 0 && bIndex >=0 ) {
      if (nums1[aIndex] < nums2[bIndex]) {
        nums1[cIndex--] = nums2[bIndex];
        bIndex--;
      } else {
        nums1[cIndex--] = nums1[aIndex];
        aIndex--;
      }
    }
    // replace remaining elements from b to a
    while (bIndex >= 0) {
      nums1[bIndex] = nums2[bIndex];
      bIndex--;
    }
    System.out.println(Arrays.toString(nums1));
  }
}

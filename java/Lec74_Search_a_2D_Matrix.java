/** https://leetcode.com/problems/search-a-2d-matrix/ */
public class Lec74_Search_a_2D_Matrix {
  public static void main(String[] args) {}

  public boolean searchMatrix(int[][] matrix, int target) {
    int lastColumnIndex = matrix[0].length - 1;
    int rowIndex = 0;
    while (rowIndex <= lastColumnIndex && matrix[rowIndex][lastColumnIndex] > target) {
      rowIndex++;
    }
    for (int i = 0; i < lastColumnIndex; i++) {
      if (matrix[rowIndex][i] == target) {
        return true;
      }
    }
    return false;
  }
}

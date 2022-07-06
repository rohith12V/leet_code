public class Lec_74_Search_A_2D_matrix {
  public static void main(String[] args) {
    boolean b =
        new Lec_74_Search_A_2D_matrix()
            .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23);
    System.out.println(b);
    b =
        new Lec_74_Search_A_2D_matrix()
            .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 30);
    System.out.println(b);
    b =
        new Lec_74_Search_A_2D_matrix()
            .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 31);
    System.out.println(b);
    b =
        new Lec_74_Search_A_2D_matrix()
            .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 56);
    System.out.println(b);
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int lastIndex = matrix[0].length;
    int row = implementBST(matrix, 0, lastIndex - 1, lastIndex, target);
    return implementBSTV2(matrix, 0, lastIndex - 1, row, target)
        || implementBSTV2(matrix, 0, lastIndex - 1, row + 1, target);
  }

  private int implementBST(int[][] matrix, int low, int high, int lastIndex, int target) {
    if (low < high) {
      int mid = (low + high) / 2;
      if (matrix[mid][lastIndex - 1] == target) {
        return mid;
      }
      if (matrix[mid][lastIndex - 1] > target) {
        return implementBST(matrix, low, mid - 1, lastIndex, target);
      }
      if (matrix[mid][lastIndex - 1] < target) {
        return implementBST(matrix, mid + 1, high, lastIndex, target);
      }
    }
    return low;
  }

  private boolean implementBSTV2(int[][] matrix, int low, int high, int rowIndex, int target) {
    if (rowIndex < 0 || rowIndex > matrix.length - 1) return false;
    if (low <= high) {
      int mid = (low + high) / 2;
      if (matrix[rowIndex][mid] == target) {
        return true;
      }
      if (matrix[rowIndex][mid] > target) {
        return implementBSTV2(matrix, low, mid - 1, rowIndex, target);
      }
      if (matrix[rowIndex][mid] < target) {
        return implementBSTV2(matrix, mid + 1, high, rowIndex, target);
      }
    }
    return false;
  }
}

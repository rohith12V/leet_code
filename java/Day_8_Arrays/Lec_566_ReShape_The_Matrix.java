package Day_8_Arrays;

import java.util.Arrays;

public class Lec_566_ReShape_The_Matrix {
  public static void main(String[] args) {
    int[][] ints =
        new Lec_566_ReShape_The_Matrix().matrixReshape(new int[][] {{1, 2, 3}, {5, 6, 7}}, 6, 6);
    System.out.println(Arrays.deepToString(ints));
  }

  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int colSize = mat[0].length;
    int rowSize = mat.length;
    if (colSize * rowSize != r * c) return mat;
    int[][] newArray = new int[r][c];
    int rIndex = 0;
    int cIndex = 0;

    for (int[] ints : mat) {
      for (int j = 0; j < colSize; j++) {
        newArray[rIndex][cIndex] = ints[j];
        cIndex++;
        if (cIndex >= c) {
          rIndex++;
          cIndex = 0;
        }
      }
    }
    return newArray;
  }
}

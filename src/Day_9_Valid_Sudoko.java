import java.util.Arrays;

public class Day_9_Valid_Sudoko {
  public static void main(String[] args) {
    boolean validSudoku =
        new Day_9_Valid_Sudoko()
            .isValidSudoku(
                new char[][] {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                });
    System.out.println(validSudoku);
  }

  public boolean isValidSudoku(char[][] board) {
    int[] rowBoard = new int[9];
    int[] colBoard = new int[9];
    // validate rows
    int rowIndex = 0;

    while (rowIndex < 9) {
      int k = 0;
      Arrays.fill(rowBoard, 0);
      while (k < 9) {
        if (board[rowIndex][k] == '.') {
          k++;
          continue;
        }
        if (rowBoard[board[rowIndex][k] % 49] == 0) {
          rowBoard[board[rowIndex][k] % 49] = 1;
          k++;
          continue;
        }
        return false;
      }
      rowIndex++;
    }

    // validate columns
    int colIndex = 0;

    while (colIndex < 9) {
      int k = 0;
      Arrays.fill(colBoard, 0);
      while (k < 9) {
        if (board[k][colIndex] == '.') {
          k++;
          continue;
        }
        if (colBoard[board[k][colIndex] % 49] == 0) {
          colBoard[board[k][colIndex] % 49] = 1;
          k++;
          continue;
        }
        return false;
      }
      colIndex++;
    }

    // validate 3x3 matrix
    return validateMatrix(board, 0, 0, 2, 2, rowBoard)
        && validateMatrix(board, 0, 3, 2, 5, rowBoard)
        && validateMatrix(board, 0, 6, 2, 8, rowBoard)
        && validateMatrix(board, 3, 0, 5, 2, rowBoard)
        && validateMatrix(board, 3, 3, 5, 5, rowBoard)
        && validateMatrix(board, 3, 6, 5, 8, rowBoard)
        && validateMatrix(board, 6, 0, 8, 2, rowBoard)
        && validateMatrix(board, 6, 3, 8, 5, rowBoard)
        && validateMatrix(board, 6, 6, 8, 8, rowBoard);
  }

  private boolean validateMatrix(
      char[][] board, int iStart, int jStart, int iEnd, int jEnd, int[] cost) {
    Arrays.fill(cost, 0);
    for (int i = iStart; i <= iEnd; i++) {
      for (int j = jStart; j <= jEnd; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (cost[board[i][j] % 49] == 0) {
          cost[board[i][j] % 49] = 1;
          continue;
        }
        return false;
      }
    }
    return true;
  }
}

package Day_8_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec118_Pascals_Triangle {



  public List<List<Integer>> generate(int numRows) {
    final List<List<Integer>> result = new ArrayList<>();
    // initial binding
    result.add(List.of(1));
    if (numRows == 1) return result;
    result.add(List.of(1, 1));
    int count = 2;
    while (count < numRows) {
      final ArrayList<Integer> currentRow = new ArrayList<>();
      currentRow.add(1);
      // pre processing
      int prevIndex = 0;
      int currentIndex = prevIndex + 1;
      int rowIndex = count - 1;
      while (currentIndex < result.get(rowIndex).size()) {
        currentRow.add(
            result.get(rowIndex).get(prevIndex) + result.get(rowIndex).get(currentIndex));
        prevIndex++;
        currentIndex++;
      }
      currentRow.add(1);
      result.add(currentRow);
      count++;
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> generate = new Lec118_Pascals_Triangle().generate(5);
    System.out.println(generate);

  }
}

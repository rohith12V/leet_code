package Day_3_Binary_Search.Lec15_3_Sum;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandom {
  public static void main(String[] args) {
    int min = -100;
    int max = 100;

    // Generate random int value from 50 to 100
    List<String> arr = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
      arr.add(String.valueOf(random_int));
    }
    System.out.println(String.join("\n", arr));
  }
}

package Day_7_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lec350_Intersection_Of_Two_Arrays {
  public static void main(String[] args) {
    int[] intersect =
        new Lec350_Intersection_Of_Two_Arrays()
            .intersect(new int[] {1, 1, 3, 4}, new int[] {1, 2, 3, 1});
    System.out.println(Arrays.toString(intersect));
  }

  public int[] intersect(int[] a, int[] b) {
    if (Math.min(a.length, b.length) == 0) return new int[] {};
    final ArrayList<Integer> result = new ArrayList<>();
    final HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int item : a) {
      if (frequencyMap.containsKey(item)) {
        frequencyMap.put(item, frequencyMap.get(item) + 1);
      } else {
        frequencyMap.put(item, 1);
      }
    }

    for (int item : b) {
      if (frequencyMap.containsKey(item) && frequencyMap.get(item) > 0) {
        result.add(item);
        frequencyMap.put(item, frequencyMap.get(item) - 1);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}

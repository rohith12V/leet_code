import java.util.HashMap;
import java.util.LinkedHashMap;

public class Lec_387_First_Unique_Char_In_A_String {
  public static void main(String[] args) {
    int leetcode = new Lec_387_First_Unique_Char_In_A_String().firstUniqChar("labca");
    System.out.println(leetcode);
  }

  public int firstUniqChar(String s) {
    final HashMap<Character, Integer> freqMap = new LinkedHashMap<>();
    int index = 0;
    for (char c : s.toCharArray()) {
      if (freqMap.containsKey(c)) {
        freqMap.put(c, freqMap.get(c) + 1);
      } else {
        freqMap.put(c, 1);
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (freqMap.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }
}

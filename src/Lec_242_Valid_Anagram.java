import java.util.HashMap;
import java.util.Objects;

public class Lec_242_Valid_Anagram {
  public static void main(String[] args) {
    //
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    final HashMap<Character, Integer> sFreqMap = new HashMap<>();
    buildFrequency(sFreqMap, s);
    final HashMap<Character, Integer> tFreqMap = new HashMap<>();
    buildFrequency(tFreqMap, t);
    if (sFreqMap.size() != tFreqMap.size()) return false;

    return sFreqMap.entrySet().stream()
        .allMatch(
            entry -> {
              return tFreqMap.containsKey(entry.getKey())
                  && Objects.equals(tFreqMap.get(entry.getKey()), entry.getValue());
            });
  }

  private void buildFrequency(HashMap<Character, Integer> freqMap, String string) {
    int length = string.length();
    for (int i = 0; i < length; i++) {
      freqMap.putIfAbsent(string.charAt(i), 0);
      freqMap.put(string.charAt(i), freqMap.get(string.charAt(i)) + 1);
    }
  }
}

import java.util.HashMap;

public class Lec_383_RanSom {
  public static void main(String[] args) {
    //
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    final HashMap<Character, Integer> freqMap = new HashMap<>();
    buildFrequency(freqMap, magazine);
    int length = ransomNote.length();
    for (int i = 0; i < length; i++) {
      if (!freqMap.containsKey(ransomNote.charAt(i))) return false;
      if (freqMap.get(ransomNote.charAt(i)) < 1) return false;
      freqMap.computeIfPresent(ransomNote.charAt(i), (character, integer) -> integer - 1);
    }
    return true;
  }

  private void buildFrequency(HashMap<Character, Integer> freqMap, String string) {
    int length = string.length();
    for (int i = 0; i < length; i++) {
      freqMap.putIfAbsent(string.charAt(i), 0);
      freqMap.put(string.charAt(i), freqMap.get(string.charAt(i)) + 1);
    }
  }
}

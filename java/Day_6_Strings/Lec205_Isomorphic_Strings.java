package Day_6_Strings;

import java.util.HashMap;

/** ISO MORPHIC STRINGS */
public class Lec205_Isomorphic_Strings {
  public static void main(String[] args) {
    new Lec205_Isomorphic_Strings().isIsomorphic("bbbaaaba", "aaabbbba");
  }

  public boolean isIsomorphic(String s, String t) {
    final HashMap<Character, Character> sourceMap = new HashMap<>();
    final HashMap<Character, Character> targetMap = new HashMap<>();
    if (s.length() != t.length()) return false;
    for (int i = 0; i < s.length(); i++) {
      final char sChar = s.charAt(i);
      final char tChar = t.charAt(i);
      if (targetMap.containsKey(tChar) && targetMap.get(tChar) != sChar) return false;
      if (sourceMap.containsKey(sChar) && sourceMap.get(sChar) != tChar) return false;
      sourceMap.put(sChar, tChar);
      targetMap.put(tChar, sChar);
    }
    return true;
  }
}
/**
 * Case - 1 ( both are equal ) s -> dad t -> dad
 *
 * <p>Case - 2 ( not equal ) s -> bbbaaaba t -> aaabbbba sMap -> b -> a s -> aaaaaaaa ( i = 0 1 2 )
 * sMap -> a -> b s -> aaabbbab ( i = 3 4 5 ) s[6] = a t[6] = b (
 */

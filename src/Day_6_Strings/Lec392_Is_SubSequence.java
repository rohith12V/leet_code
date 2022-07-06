package Day_6_Strings;

public class Lec392_Is_SubSequence {
  public static void main(String[] args) {
    System.out.println(new Lec392_Is_SubSequence().isSubsequence("abc", "ahbgdc"));
    System.out.println(new Lec392_Is_SubSequence().isSubsequence("abc", "ahbgd"));
  }

  public boolean isSubsequence(String s, String t) {
    int sLength = s.length();
    int tLength = t.length();
    // if T has less length that indicates we can never form a subsequence which can match with S
    if (tLength < sLength) return false;
    int sIndex = 0;
    int tIndex = 0;

    while (sIndex < sLength && tIndex < tLength) {
      // increment s Pointer only when they match
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      // T Pointer will move to next on every iteration
      tIndex++;
    }
    // if s Pointer has covered all the chars its length will be equal to Pointer Index
    return sIndex == sLength;
  }
}

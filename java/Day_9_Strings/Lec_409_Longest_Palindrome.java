package Day_9_Strings;

import java.util.HashMap;

public class Lec_409_Longest_Palindrome {
  public static void main(String[] args) {
    System.out.println(new Lec_409_Longest_Palindrome().longestPalindromeSoFar("abccccdd"));
  }

  public int longestPalindrome(String s) {
    int[][] dp = new int[s.length()][s.length()];

    // case - 1 Fill the diagonals as they are palindromes
    int diagonalIndex = 0;
    while (diagonalIndex < s.length()) {
      dp[diagonalIndex][diagonalIndex] = 1;
      diagonalIndex++;
    }

    int maxLengthFoundSoFar = 1;

    int row = 0;
    while (row < s.length()) {
      int i = 0;
      int j = row + i + 1;
      while (j < s.length()) {
        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) ? 1 : 0;
        if (dp[i][j] == 1) {
          maxLengthFoundSoFar = Math.max(Math.abs(j - i + 1), maxLengthFoundSoFar);
        }
        i++;
        j++;
      }
      row++;
    }
    return maxLengthFoundSoFar;
  }

  public int longestPalindromeSoFar(String s) {
    final HashMap<Character, Integer> frequency = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char aChar : chars) {
      if (frequency.containsKey(aChar)) {
        frequency.put(aChar, frequency.get(aChar) + 1);
      } else {
        frequency.put(aChar, 1);
      }
    }
    int maxLength = 0;
    boolean flag = false;
    for (Integer val : frequency.values()) {
      if (val % 2 != 0) {
        flag = true;
      }
      maxLength += (val / 2) * 2;
    }
    return flag ? maxLength + 1 : maxLength;
  }
}

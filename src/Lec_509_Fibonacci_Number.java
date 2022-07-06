public class Lec_509_Fibonacci_Number {
  public static void main(String[] args) {
    for (int i = 0; i < 31; i++) {
      int e = new Lec_509_Fibonacci_Number().fibDP(i);
      System.out.println(e);
    }
  }

  public int fibDP(int n) {
    int[] arr = new int[31];
    arr[0] = 0;
    arr[1] = 1;
    fibDPUtil(n, arr);
    return n < 2 ? arr[n] : arr[n - 1] + arr[n - 2];
  }

  public int fibDPUtil(int n, int[] dp) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (dp[n] != 0) return dp[n];
    dp[n] = fibDPUtil(n - 1, dp) + fibDPUtil(n - 2, dp);
    return dp[n];
  }
}

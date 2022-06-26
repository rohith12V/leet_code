package Day_5_Binary_Search;

public class Lec278_First_Bad_version {
  public static void main(String[] args) {
    System.out.println(
            new Lec278_First_Bad_version().firstBadVersion(2126753390)
    );
  }
    public int firstBadVersion(int n) {
      return isBadVersionUtil(0, n);
    }

    private int isBadVersionUtil(int low, int high) {
      if (low < high) {
          int mid = (low/2 + high/2);
          if (isBadVersion(mid)) {
              return isBadVersionUtil(low, mid);
          }
          else return isBadVersionUtil(mid + 1, high);
      }
      return  low;
    }

    private boolean isBadVersion(int mid) {
      return mid>=1702766719 + 789;
    }
}

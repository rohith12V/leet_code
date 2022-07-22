public class Lec_090_Factorial_OF_A_Number {
    public static void main(String[] args) throws IllegalArgumentException {
        final Lec_090_Factorial_OF_A_Number obj = new Lec_090_Factorial_OF_A_Number();
        // case - 1
        System.out.println(obj.fact(10));
        System.out.println(obj.factIterative(10));
        // case - 2
        System.out.println(obj.fact(-10));
        System.out.println(obj.factIterative(-10));
    }

    /**
     * Recursive Solution
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */
    private int fact(int n) {
        // invalid Case
        if (n < 0) return -1;
        if (n == 0) return 1;
        return n * fact(n - 1);
    }

    /**
     * Iterative Solution
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     */
    private int factIterative(int n) {
        if (n < 0) return -1;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

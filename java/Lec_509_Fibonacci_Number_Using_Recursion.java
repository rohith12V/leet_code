public class Lec_509_Fibonacci_Number_Using_Recursion {
    public static void main(String[] args) {
        final Lec_509_Fibonacci_Number_Using_Recursion ob = new Lec_509_Fibonacci_Number_Using_Recursion();
        System.out.println(ob.calcFibonacciNumber(4));
    }
    private int calcFibonacciNumber(int n) {
        if (n >=0 && n <= 1) return n ;
        return calcFibonacciNumber(n -1) + calcFibonacciNumber(n - 2);
    }
}

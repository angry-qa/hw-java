package hw1;

public class Fibonacci {

  public int fib(int i) {
    if  (i < 2) {
      return i;
    } else {
      return fib(i-1) + fib(i-2);
    }
  }

  public void calc(int n) {
    System.out.println("Fibonacci " + n + " = " + fib(n));
  }

}

package hw1;

public class Main {

  private static Sqrt sqrt = new Sqrt();
  private static Palindrome palindrome = new Palindrome();
  private static Summ summ = new Summ();
  private static LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
  private static FizzBuzz fizzbuzz = new FizzBuzz();
  private static Fibonacci fibonacci = new Fibonacci();

  public static void main(String[] args) {
    palindrome.check();
    summ.check();
    lengthOfLastWord.check();
    sqrt.calculate();
    fizzbuzz.check();
    fibonacci.calc(10);
  }

}

package hw1;

public class FizzBuzz {

  public String fizzBuzz(int i) {

    String val = "";

    if (i % 3 == 0) {
      val += "fizz";
    }

    if (i % 5 == 0) {
      val += "buzz";
    }

    return val;
  }

  public void check() {
    System.out.println("i = 10: " + fizzBuzz(10));
    System.out.println("i = 10: " + fizzBuzz(15));
    System.out.println("i = 10: " + fizzBuzz(16));
  }


}

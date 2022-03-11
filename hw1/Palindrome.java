package hw1;

public class Palindrome {

  private static boolean isPalindrome(int x) {

    if(x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while(x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    return x == revertedNumber || x == revertedNumber / 10;

  }

  public void check() {
    int[] palindroms  = {1234321, 1234, -1234321};
    for (Integer palindrome : palindroms) {
      System.out.println("Is '" + palindrome + "' palindrome? " + isPalindrome(palindrome));
    }
    System.out.println("");
  }

}

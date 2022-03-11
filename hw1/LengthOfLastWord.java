package hw1;

public class LengthOfLastWord {

  private static int lengthOfLastWord(String s) {
      String trim = s.trim();
      return trim.length() - (trim.lastIndexOf(' ') + 1);
  }

  public static void check() {
    String s = "Hello World";
    System.out.println("The last word length: " + lengthOfLastWord(s));
    System.out.println("");
  }

}

package hw1;

public class Sqrt {

  private static int mySqrt(int x) {
    int s = 0, e = x, ans = 0;
    while(s<=e)
    {
      long m = (s+e)/2;
      if(m*m==x)
        return (int)m;
      else if(m*m<x)
      {
        s = (int)m+1;
        ans = (int)m;
      }
      else
        e = (int)m-1;
    }
    return ans;
  }

  public static void calculate() {
    int x = 4;
    System.out.println("The square root of " + x + " is " + mySqrt(x));
    System.out.println("");
  }

}

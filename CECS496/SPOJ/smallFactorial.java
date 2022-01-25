import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, size, count = 1;
    size = in.nextInt();
    while (size >= count) {
      n = in.nextInt();
      BigInteger factorial = BigInteger.ONE;
      for (int i = 1; i <= n; i++) {
        factorial = factorial.multiply(BigInteger.valueOf(i));
      }
      System.out.println(factorial);
      count = count + 1;
    }
  }
}
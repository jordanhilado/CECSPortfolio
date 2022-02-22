import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int lines = input.nextInt();

    for (int i = 0; i < lines; i++) {
      int reversedFirst = 0;
      int reversedSecond = 0;

      int firstNum = input.nextInt();
      int firstNumLength = (firstNum + "").length();
      int secondNum = input.nextInt();
      int secondNumLength = (secondNum + "").length();
      // 4358 754
      // 8534 457 = 8991 => 1998
      for (int j = firstNumLength - 1; j >= 0; j--) {
        reversedFirst += (firstNum % 10) * Math.pow(10, j);
        firstNum /= 10;
      }
      
      for (int j = secondNumLength - 1; j >= 0; j--) {
        reversedSecond += (secondNum % 10) * Math.pow(10, j);
        secondNum /= 10;
      }

      int reversedTotal = 0;
      int total = reversedFirst + reversedSecond;
      int totalLength = (total + "").length();
      
      for (int j = totalLength - 1; j >= 0; j--) {
        reversedTotal += (total % 10) * Math.pow(10, j);
        total /= 10;
      }

      System.out.println(reversedTotal);
    }
  }
}

// 3 24 1 4358 754 305 794
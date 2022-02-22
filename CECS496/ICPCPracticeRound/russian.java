import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first;
        int second;
        int sum = 0;
        while (input.hasNextInt()) {
            first = input.nextInt();
            second = input.nextInt();

            if (first % 2 != 0)
                sum += second;

            System.out.println(first + " " + second + " " + sum);

            while (first != 1) {
                first /= 2;
                second *= 2;
                System.out.print(first + " " + second);

                if (first % 2 != 0)
                    sum += second;

                System.out.println(" " + sum);
            }
            System.out.println("= " + sum);

            sum = 0;
        }
    }
}
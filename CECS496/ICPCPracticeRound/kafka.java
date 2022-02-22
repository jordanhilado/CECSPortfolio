import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer = 1;
        int clerk;
        int previous = -1;
        int numberOfProbs = input.nextInt();
        for (int i = 0; i < numberOfProbs; i++) {
            clerk = input.nextInt();

            if (previous != -1) {
                if (clerk < previous) {
                    answer++;
                }
            }
            previous = clerk;
        }
        System.out.println(answer);
    }
}
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int needleLength = scan.nextInt();
            String needle = scan.next();
            String haystack = scan.next();
            String suffix = needle.substring(0, 1);

            if (haystack.length() >= needle.length()) {
                for (int i = 0; i < haystack.length() - 1; i++) {
                    if (haystack.substring(i, i + 1).equals(suffix) && (haystack.length() - (i + needleLength) >= 0)) {
                        if (haystack.substring(i, i + needleLength).equals(needle))
                            System.out.println(i);
                    }
                }
                System.out.println();
            }
        }
    }
}
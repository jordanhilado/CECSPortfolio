import java.io.*;
class unary { //main class needs to match filename
    public static void main(String[] args) throws IOException {
        int n;
        String s;
        BufferedReader stdin;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        // wrap BufferedReader around InputStreamReader around System.in
        while ((s = stdin.readLine()) != null) {
            // BufferedReader.readLine returns null at end-of-file
            n = Integer.parseInt(s);
            System.out.print(n + " ");
            for (int i = n - 1; i > 0; i--) {
                System.out.print("1");
            }
            System.out.println("0"); // println() writes an ASCII 0x0A
        }
        System.exit(0); // indicate normal program termination
    }
}
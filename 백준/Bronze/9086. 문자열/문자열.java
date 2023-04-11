import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            System.out.println(first + "" + last);
        }
    }
}

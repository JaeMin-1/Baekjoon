import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int cnt = 0;

        int N = 1;
        while(S >= N) {
            S -= N;
            N++;
            cnt++;
        }
        System.out.println(cnt);
    }
}

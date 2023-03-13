import java.io.*;
import java.util.*;

public class Main {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(make_1(N));
    }

    public static int make_1(int N) {
        if (N == 0 || N == 1) {
            return dp[N];
        }

        if (dp[N] > 0) {
            return dp[N];
        }

        if (N % 6 == 0) {
            dp[N] = Math.min(make_1(N-1), Math.min(make_1(N/2), make_1(N/3))) + 1;
        } else if (N % 3 == 0) {
            dp[N] = Math.min(make_1(N/3), make_1((N-1))) + 1;
        } else if (N % 2 == 0) {
            dp[N] = Math.min(make_1(N/2), make_1(N-1)) + 1;
        } else {
            dp[N] = make_1(N-1) + 1;
        }

        return dp[N];
    }
}

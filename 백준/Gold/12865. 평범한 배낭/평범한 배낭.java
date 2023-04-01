import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 용량
        int[] w = new int[N+1]; // 물건의 무게
        int[] v = new int[N+1]; // 물건의 가치
        int[][] dp = new int[N+1][K+1]; // dp[i][j]: i번째 물건까지 선택하고 배낭 용량이 j일 때 최대 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

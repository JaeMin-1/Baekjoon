import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int[][] arr;
    static int answer;
    public static void Solution() {
        for(int i=0; i<=n/2; i++) {
            answer += arr[i][n/2];
            for(int j=1; j<=i; j++) {
                int sum = arr[i][n/2-j] + arr[i][n/2+j];
                answer += sum;
            }
        }
        for(int i=n-1; i>n/2; i--) {
            answer += arr[i][n/2];
            for(int j=1; j<=n-i-1; j++) {
                int sum = arr[i][n/2-j] + arr[i][n/2+j];
                answer += sum;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for(int i=0; i<n; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            answer = 0;
            Solution();

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

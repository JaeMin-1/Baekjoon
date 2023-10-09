import java.io.*;
import java.util.*;

class Solution {
    static int[][] arr;
    static int answer;
    public static void Solution() {
        for(int i=0; i<100; i++) {
            int sum = 0;
            for(int j=0; j<100; j++) {
                sum += arr[i][j];
            }
            answer = Math.max(answer, sum);
        }
        for(int j=0; j<100; j++) {
             int sum = 0;
            for(int i=0; i<100; i++) {
                sum += arr[i][j];
            }
            answer = Math.max(answer, sum);
        }
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<100; i++) {
            sum1 += arr[i][i];
            sum2 += arr[99-i][i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            arr = new int[100][100];
            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            Solution();

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

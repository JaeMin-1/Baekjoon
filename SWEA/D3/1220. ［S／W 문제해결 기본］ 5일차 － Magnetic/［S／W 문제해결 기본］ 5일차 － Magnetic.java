import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[][] arr;
    public static void Solution() {
        for(int j=0; j<100; j++) {
            boolean flag = false;
            for(int i=0; i<100; i++) {
                if(arr[i][j] == 0) continue;
                else if(arr[i][j] == 1)flag = true;
                else if(flag && arr[i][j] == 2) {
                    answer++;
                    flag = false;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
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

import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
    static int answer;
    static int[][] arr;
    static int[] ch;
    public static void Solution(int v, int count) {
        answer = Math.max(answer, count);
        for(int i=1; i<=n; i++) {
            if(arr[v][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                Solution(i,count+1);
                ch[i] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ch = new int[n+1];
            arr = new int[n+1][n+1];

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            answer = 1;
            for(int i=1; i<=n; i++) {
                ch[i] = 1;
                Solution(i, 1);
                ch[i] = 0;
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

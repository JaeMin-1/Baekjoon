import java.io.*;
import java.util.*;

class Solution {
    static int n, k;
    static int answer;
    static int[] arr;
    public static void DFS(int s, int sum) {
        if(sum > k) return;
        if(s == n) {
            if(sum == k) answer++;
        }
        else {
            DFS(s + 1, sum + arr[s]);
            DFS(s + 1, sum);
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
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            DFS(0,0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

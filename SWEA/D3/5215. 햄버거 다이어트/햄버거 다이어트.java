import java.io.*;
import java.util.*;

class Solution {
    static int n, l;
    static int answer;
    static int[] score;
    static int[] kcal;
    public static void DFS(int s, int sumKcal, int sumScore) {
        if(sumKcal > l) return;
        if(s == n) {
            answer = Math.max(answer, sumScore);
        }
        else {
            DFS(s+1, sumKcal, sumScore);
            DFS(s+1, sumKcal+kcal[s], sumScore+score[s]);
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
            l = Integer.parseInt(st.nextToken());

            score = new int[n];
            kcal = new int[n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            DFS(0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

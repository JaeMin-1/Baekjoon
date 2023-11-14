import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
    static int answer;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] ch;
    public static void Solution(int v, int count) {
        answer = Math.max(answer, count);
        for(int nv : arr.get(v)) {
            if(ch[nv] == 0) {
                ch[nv] = 1;
                Solution(nv, count+1);
                ch[nv] = 0;
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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ch = new int[n+1];
            arr = new ArrayList<>();
            for(int i=0; i<=n; i++) {
                arr.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.get(a).add(b);
                arr.get(b).add(a);
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

import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[] arr, arr2;
    public static void DFS(int x) {
        if(answer == 1) return;
        if(arr[x] == 99 || arr2[x] == 99) {
            answer = 1;
            return;
        }
        else {
            if(arr[x] != 0) {
                DFS(arr[x]);
            }
            if(arr2[x] != 0) {
                DFS(arr2[x]);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr = new int[100];
            arr2 = new int[100];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(arr[a] == 0) arr[a] = b;
                else arr2[a] = b;
            }
            answer = 0;
            DFS(0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

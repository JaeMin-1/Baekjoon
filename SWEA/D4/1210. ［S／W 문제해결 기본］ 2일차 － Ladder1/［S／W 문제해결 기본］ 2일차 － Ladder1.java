import java.io.*;
import java.util.*;

class Solution {
    static int[] dx= {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    static int answer;
    public static void DFS(int x, int y) {
        if(answer!=0) return;
        if(x==0) answer = y;
        else {
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<100 && ny>=0 && ny<100 && arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    DFS(nx, ny);
                    arr[nx][ny] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            answer = 0;
            int n = Integer.parseInt(br.readLine());
            int a=0, b=0;
            arr = new int[100][100];
            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 2) {
                        a = i;
                        b = j;
                    }
                }
            }
            DFS(a, b);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

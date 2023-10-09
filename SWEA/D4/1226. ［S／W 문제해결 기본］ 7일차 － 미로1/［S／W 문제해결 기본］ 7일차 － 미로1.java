import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1, 1,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int[][] arr;
    static int answer;
    public static void DFS(int x, int y) {
        if(answer == 1) return;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>0 && nx<16 && ny>0 && ny<16 && arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                DFS(nx, ny);
                arr[nx][ny] = 0;
            }
            if(arr[nx][ny] == 3) {
                answer = 1;
                return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            arr = new int[16][16];
            for(int i=0; i<16; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<16; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            answer = 0;
            DFS(1,1);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

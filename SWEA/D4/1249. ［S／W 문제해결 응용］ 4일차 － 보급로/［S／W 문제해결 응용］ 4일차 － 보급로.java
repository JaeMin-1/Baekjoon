import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int[][] arr, ans;
    public static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0,0));
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            if(ans[n-1][n-1] <= ans[p.x][p.y]) continue;
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n) {
                    if(ans[nx][ny] > ans[p.x][p.y]+arr[nx][ny]) {
                        Q.offer(new Point(nx, ny));
                        ans[nx][ny] = ans[p.x][p.y]+arr[nx][ny];
                    }
                }
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
            ans = new int[n][n];
            for(int i=0; i<n; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            for(int i=0; i<n; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;

            BFS();
            sb.append("#").append(test_case).append(" ").append(ans[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] arr;
    static Queue<Point> Q = new LinkedList<>();
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void DFS(int L) {
        if(L==3) {
            BFS();
        }
        else {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] == 0) {
                        arr[i][j] = 1;
                        DFS(L+1);
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void BFS() {
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(arr[i][j] == 2) Q.offer(new Point(i, j));

        int[][] clone = new int[n][m];
        for(int i=0; i<arr.length; i++) {
            clone[i] = arr[i].clone();
        }

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point tmp = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && clone[nx][ny] == 0) {
                        clone[nx][ny] = 2;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(clone[i][j] == 0) sum ++;
            }
        }
        answer = Math.max(answer,sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0);
        System.out.println(answer);
    }
}

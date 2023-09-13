import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] map, dis;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Point> Q = new LinkedList<>();
    public static void BFS() {
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point tmp = Q.poll();
                map[tmp.x][tmp.y] = 0;
                for(int j=0; j<4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] == 1) {
                        Q.offer(new Point(nx, ny));
                        dis[nx][ny] = L+1;
                        map[nx][ny] = 0;  //간 곳은 0으로 바꿔서 더이상 안가도록 함.
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        BFS();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && dis[i][j] == 0) dis[i][j] = -1;
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
}

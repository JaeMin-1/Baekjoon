import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            int ans = 0;

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;
        for(int i=0; i<8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x>=0 && x<h && y>=0 && y<w) {
                if(map[x][y] == 1 && !visited[x][y])
                    dfs(x, y);
            }
        }
    }
}
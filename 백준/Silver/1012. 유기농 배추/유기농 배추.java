import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());  //가로의 길이
            N = Integer.parseInt(st.nextToken());  //세로의 길이
            K = Integer.parseInt(st.nextToken());  //간선의 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            int cnt = 0;
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;
        for(int i=0; i<4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x>=0 && x<M && y>=0 && y<N) {
                if(!visited[x][y] && map[x][y] == 1) {
                    dfs(x, y);
                }
            }
        }

    }
}

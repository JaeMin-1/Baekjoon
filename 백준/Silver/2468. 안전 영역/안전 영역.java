import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int ans = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        int min = 101;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max) max = map[i][j];
                if(map[i][j] < min) min = map[i][j];
            }
        }
        for(int k=min-1; k<=max; k++) { //하나도 안잠기는 min-1 강수량부터 모두 잠기는 max강수량까지 고려
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                        if(map[i][j] > k && !visited[i][j]) { //강수량보다 높고 방문안했으면 안전구역 스타트
                            dfs(i, j, k);
                            cnt++;
                        }
                }
            }
            //visited 초기화, 새로운 강수량에 대해 다시 해야하므로.
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    visited[i][j] = false;

            if(cnt > ans) ans = cnt;       //안전구역의 최대 갯수 갱신
            cnt = 0;                       //visited 와 마찬가지로 초기화, 새로운 강수량에 대해 다시 해야하므로.
        }

        System.out.println(ans);
    }

    static void dfs(int a, int b, int k) {
        visited[a][b] = true;
        for(int i=0; i<4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x>=0 && x<N && y>=0 && y<N) {
                if(map[x][y] > k && !visited[x][y]) dfs(x,y,k);
            }
        }
    }



}

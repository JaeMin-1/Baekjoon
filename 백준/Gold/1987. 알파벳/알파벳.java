import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int cnt) {
        ans = Math.max(ans, cnt);

        visited[map[x][y] - 'A'] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<R && ny>=0 && ny<C) {
                if (!visited[map[nx][ny] - 'A'])
                    dfs(nx, ny, cnt + 1);
            }
        }

        visited[map[x][y] - 'A'] = false;
    }
}
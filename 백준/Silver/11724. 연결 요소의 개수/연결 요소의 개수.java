import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  //정점의 개수
        M = Integer.parseInt(st.nextToken());  //간선의 개수

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        while(M-- >0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false) { // 방문한 적 없는 노드라면 dfs.
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int start) {
        visited[start] = true;

        for(int i=1; i<=N; i++) {
            if(map[start][i] == 1 && !visited[i]) dfs(i);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] arr;
    public static boolean[] check;
    public static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  //정점의 개수
        M = Integer.parseInt(st.nextToken());  //간선의 개수
        V = Integer.parseInt(st.nextToken());  //탐색을 시작할 정점의 번호

         arr = new int[N+1][N+1];
        check = new boolean[N+1];

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        check = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=N; i++) {
            if(arr[start][i] == 1 && !check[i])    //그 다음 갈 정점에 간선이 연결되어있어야 하며, 그 다음 갈 정점이 방문하지 않았던 곳이어야 한다.
                dfs(i);                            //깊이 우선 탐색이므로 재귀를 통해 다음 정점 입장에서 다시 재탐색
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            //넓이 우선 탐색이므로 재귀없이 순수 for문으로 한 정점에 대해 모든 연결된 점을 찾아 큐에 넣는다.
            //그리고 다시 while문으로 돌아가 전에 큐에 추가했던 점들을 순차적으로 다시 넓이 우선 탐색을 한다.
            //큐의 특성으로 인해 먼저 찾아진 연결된 점은 먼저 while문을 통해 for문을 돌기때문에 넓이 우선 탐색이 가능해진다.
            for(int i=1; i<=N; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);                           
                    check[i] = true;
                }
            }
        }
    }
}

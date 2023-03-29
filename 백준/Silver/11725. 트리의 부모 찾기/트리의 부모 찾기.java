import java.io.*;
import java.util.*;

public class Main {
    static int N;            //노드의 개수
    static int[] parents;    //부모 배열
    static boolean[] visited;
    static ArrayList<Integer>[] tree;  //리스트의 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i=1; i<=N; i++)
            tree[i] = new ArrayList<Integer>();

        for(int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        for(int i=1; i<=N; i++)
            if(!visited[i]) dfs(i);

        for (int i = 2; i <= N; i++)
            System.out.println(parents[i]);
    }

    static void dfs(int a) {
        visited[a] = true;

        for(int i : tree[a]) {
            if(!visited[i]) {    //방문하지않았다면
                parents[i] = a;  //a는 다음으로 갈 i의 부모가 되므로 부모 노드에 입력
                dfs(i);
            }
        }
    }
}

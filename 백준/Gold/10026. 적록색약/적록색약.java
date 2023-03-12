import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[][] arr1;
    public static char[][] arr2;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] visit1; //적록색약이 아닌 경우
    public static boolean[][] visit2; //적록색약이 맞는 경우
    public static int cnt1 = 0;
    public static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new char[N][N];
        arr2 = new char[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                arr1[i][j] = str.charAt(j);
                arr2[i][j] = str.charAt(j);
                if(arr2[i][j] == 'R') arr2[i][j] = 'G';
            }
        }

        //dfs함수는 인접한 동서남북 지점을 모두 확인하며 재귀로 진행된다.
        //계속해서 재귀적으로 진행되다가, 이미 다른 서로 다른 재귀들이 각각 방문하면서 같은 색을 전부 방문하고
        //더이상 새로 방문할 같은 색이 없으면 자연스레 처음으로부터 파생된 모든 재귀가 끝나면서 dfs함수는 종료되고 영억 수에 해당하는 cnt가 +1이된다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit1[i][j]) {
                    dfs(i, j, arr1, visit1);                //인접한 모든 같은 색상 탐색
                    cnt1++;
                }
                if(!visit2[i][j]) {
                    dfs(i,j, arr2, visit2);                //인접한 모든 같은 색상 탐색
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    public static void dfs(int a, int b, char[][] arr, boolean[][] visit) {
        visit[a][b] = true;
        int c = arr[a][b];          //(a,b) 좌표의 색 종류

        for(int i=0; i<4; i++) {
            int nextA = a + dx[i];             //탐색할 다음 x좌표
            int nextB = b + dy[i];             //탐색할 다음 y좌표

            if(nextA<0 || nextB<0 || nextA>=N || nextB>=N) continue;          //x든 y든 하나라도 0보다 작거나 N보다 크면, 즉 그림을 벗어나면 무시
            else if(arr[nextA][nextB] == c && !visit[nextA][nextB])         //다음 좌표가 현 좌표와 같은 색이고 방문하지 않았던 좌표라면
                dfs(nextA, nextB, arr, visit);                              //이동해서 이 좌표를 기준으로 dfs 실행, 즉 재귀.
        }
    }
}

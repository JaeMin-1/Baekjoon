import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;
    static String str;
    static HashSet<String> list;
    static int[][] arr;
    public static void DFS(int s, int x, int y) {
        if(s == 6) {
            list.add(str);
        }
        else {
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<4 && ny>=0 && ny<4) {
                    str += arr[nx][ny];
                    DFS(s+1, nx, ny);
                    str = str.substring(0, str.length()-1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr = new int[4][4];
            for(int i=0; i<4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            list = new HashSet<>();
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    str = "";
                    str += arr[i][j];
                    DFS(0, i, j);
                }
            }
            answer = list.size();

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

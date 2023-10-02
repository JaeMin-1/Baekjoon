import java.io.*;
import java.util.*;

class Point {
    int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1 ,0, -1};
    static int[][] arr, ch;
    static int n, m, sum;
    static int answer = 0;
    public static void DFS(int L, int x, int y, int sum) {
        if(L==3) {
            answer = Math.max(answer, sum);
        }
        else {
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(L+1, nx, ny, sum+arr[nx][ny]);
                    ch[nx][ny] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ch[i][j] = 1;
                DFS(0,i,j, arr[i][j]);
                ch[i][j] = 0;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i-1>=0 && i-1<n && j>=0 && j<m)
                    if(i>=0 && i<n && j+1>=0 && j+1<m)
                        if(i+1>=0 && i+1<n && j>=0 && j<m) {
                            sum = arr[i][j];
                            sum += arr[i-1][j];
                            sum += arr[i][j+1];
                            sum += arr[i+1][j];
                            answer = Math.max(answer, sum);
                        }
                if(i>=0 && i<n && j+1>=0 && j+1<m)
                    if(i+1>=0 && i+1<n && j>=0 && j<m)
                        if(i>=0 && i<n && j-1>=0 && j-1<m) {
                            sum = arr[i][j];
                            sum += arr[i][j+1];
                            sum += arr[i+1][j];
                            sum += arr[i][j-1];
                            answer = Math.max(answer, sum);
                        }
                if(i+1>=0 && i+1<n && j>=0 && j<m)
                    if(i>=0 && i<n && j-1>=0 && j-1<m)
                        if(i-1>=0 && i-1<n && j>=0 && j<m) {
                            sum = arr[i][j];
                            sum += arr[i+1][j];
                            sum += arr[i][j-1];
                            sum += arr[i-1][j];
                            answer = Math.max(answer, sum);
                        }
                if(i>=0 && i<n && j-1>=0 && j-1<m)
                    if(i-1>=0 && i-1<n && j>=0 && j<m)
                        if(i>=0 && i<n && j+1>=0 && j+1<m) {
                            sum = arr[i][j];
                            sum += arr[i][j-1];
                            sum += arr[i-1][j];
                            sum += arr[i][j+1];
                            answer = Math.max(answer, sum);
                        }
            }
        }
        System.out.println(answer);
    }
}

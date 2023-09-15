import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;
    static int[] ch;
    static int n;
    public static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        while(!Q.isEmpty()) {
            int tmp = Q.poll();
            for(int i=0; i<n; i++) {
                if(arr[tmp][i] == 1 && ch[i] == 0) {
                    arr[start][i] = 1;
                    ch[i] = 1;
                    Q.offer(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            ch = new int[n];
            BFS(i);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

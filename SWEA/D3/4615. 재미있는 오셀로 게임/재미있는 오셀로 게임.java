import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
    static int[][] board;
    static int black;
    static int white;
    public static void Solution(int x, int y) {
        for(int i= -1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(i == 0 && j == 0) continue;
                int nx = x + i;
                int ny = y + j;

                boolean check = false;
                while(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] != 0) {
                    if(board[nx][ny] == board[x][y]) {
                        check = true;
                        break;
                    }
                    nx += i;
                    ny += j;
                }
                while(check) {
                    if(nx == x && ny == y) break;
                    board[nx][ny] = board[x][y];
                    nx -= i;
                    ny -= j;
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            board[n/2][n/2] = 2; //화이트가 2
            board[n/2-1][n/2] = 1; //블랙이 1
            board[n/2][n/2-1] = 1;
            board[n/2-1][n/2-1] = 2;
			
            black = 0;
            white = 0;
            
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int stone = Integer.parseInt(st.nextToken());
                if(stone == 1) board[x][y] = 1;
                else board[x][y] = 2;
                Solution(x, y);
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(board[i][j] == 1) black++;
                    if(board[i][j] == 2) white++;
                }
            }

            sb.append("#").append(test_case).append(" ").append(black).append(" ").append(white).append("\n");
        }
        System.out.println(sb);
    }
}

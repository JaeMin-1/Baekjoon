import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int [][] board;
    static int answer;
    public static void DFS(int s) {
        if(s==n) answer++;
        else {
            for(int i=0; i<n; i++) {
                boolean flag = true;
                for(int j=0; j<s; j++) {
                    for(int k=0; k<n; k++) {
                        if(board[j][k] == 1) {
                            if(i==k || s-j == i-k || s-j == k-i){
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if(flag) {
                    board[s][i] = 1;
                    DFS(s+1);
                    board[s][i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            board = new int[n][n];
            DFS(0);
            if(n == 1) answer = 1;

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

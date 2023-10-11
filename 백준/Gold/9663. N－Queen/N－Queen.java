import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] board;
    static int answer;
    public static void DFS(int s) {
        if(s==n) answer++;
        else {
            for(int i=0; i<n; i++) {
                boolean flag = true;
                for(int j=0; j<s; j++) {
                    if(i == board[j] || i-board[j] == s-j || i-board[j] == j-s) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    board[s] = i;
                    DFS(s+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        board = new int[n];
        DFS(0);
        if(n == 1) answer = 1;

        System.out.println(answer);
    }
}

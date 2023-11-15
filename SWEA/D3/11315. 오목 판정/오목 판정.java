import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static String answer;
    static char[][] arr;
    public static void Solution() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 'o') {
                    for(int k=-1; k<=1; k++) {
                        for(int l=-1; l<=1; l++) {
                            if(k!=0 || l!=0) {
                                int cnt = 1;
                                int nx = i+k;
                                int ny = j+l;
                                while(nx>=0 && nx<n && ny >=0 && ny<n && arr[nx][ny] == 'o') {
                                    cnt++;
                                    nx += k;
                                    ny += l;
                                }
                                if(cnt>=5) {
                                    answer = "YES";
                                    return;
                                }
                            }
                        }
                    }
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
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            for(int i=0; i<n; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<n; j++) {
                    arr[i][j] = str[j].charAt(0);
                }
            }
            answer = "NO";
            Solution();



            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

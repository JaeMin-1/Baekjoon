import java.io.*;
import java.util.*;

class Solution {
    static int n, k;
    static int answer;
    static char[][] arr;
    public static void Solution() {
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                for(int k=1; k<=100-j; k++) {
                    if(answer > k) continue;
                    boolean check = true;
                    for(int l=0; l<k/2; l++) {
                        if (arr[i][j + l] != arr[i][j + k - 1 - l]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        answer = Math.max(answer, k);
                    }
                }
            }
        }

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                for(int k=1; k<=100-j; k++) {
                    if(answer > k) continue;
                    boolean check = true;
                    for(int l=0; l<k/2; l++) {
                        if (arr[j + l][i] != arr[j + k - 1 - l][i]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        answer = Math.max(answer, k);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            arr = new char[100][100];
            for(int i=0; i<100; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<100; j++) {
                    arr[i][j] = str[j].charAt(0);
                }
            }

            answer = 0;
            Solution();

            sb.append("#").append(n).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

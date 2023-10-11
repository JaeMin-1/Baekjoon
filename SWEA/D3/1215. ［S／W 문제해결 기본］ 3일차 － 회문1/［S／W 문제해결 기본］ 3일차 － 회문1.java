import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static char[][] arr;
    static ArrayList<Character> tmp;
    static ArrayList<Character> reverse;
    static int answer;
    public static void Solution() {
        for(int i=0; i<8; i++) {
            for(int j=0; j<=8-n; j++) {
                tmp = new ArrayList<>();
                reverse = new ArrayList<>();
                for(int k=0; k<n; k++) {
                    tmp.add(arr[i][j+k]);
                    reverse.add(arr[i][j+k]);
                }
                Collections.reverse(reverse);
                if(Arrays.equals(tmp.toArray(), reverse.toArray())) answer++;
            }
        }
        for(int i=0; i<=8-n; i++) {
            for(int j=0; j<8; j++) {
                tmp = new ArrayList<>();
                reverse = new ArrayList<>();
                for(int k=0; k<n; k++) {
                    tmp.add(arr[i+k][j]);
                    reverse.add(arr[i+k][j]);
                }
                Collections.reverse(reverse);
                if(Arrays.equals(tmp.toArray(), reverse.toArray())) answer++;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            for(int i=0; i<8; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<8; j++) {
                    arr[i][j] = str[j].charAt(0);
                }
            }
            answer = 0;
            Solution();

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

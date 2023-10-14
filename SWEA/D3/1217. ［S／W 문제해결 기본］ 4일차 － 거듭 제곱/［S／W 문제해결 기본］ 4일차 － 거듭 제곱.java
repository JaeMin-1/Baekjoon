import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[][] arr;
    public static void Solution(int num, int k) {
        if(k==0) return;
        else{
            answer *= num;
            Solution(num, k-1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            answer = 1;
            Solution(num, k);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

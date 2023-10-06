import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2; i<n-2; i++) {
                if(arr[i] > arr[i-2] && arr[i] > arr[i-1] && arr[i] > arr[i+1] && arr[i] > arr[i+2]) {
                    int Left = Math.max(arr[i-2], arr[i-1]);
                    int Right = Math.max(arr[i+2], arr[i+1]);
                    int highest = Math.max(Left, Right);
                    answer += arr[i] - highest;
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer) .append("\n");
        }
        System.out.println(sb);
    }
}

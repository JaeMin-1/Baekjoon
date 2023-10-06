import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            for(int i=0; i<100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            while(n-->0) {
                int max = 0; int min = 101;
                int maxIndex = 0; int minIndex = 0;
                for(int i=0; i<100; i++) {
                    max = Math.max(max, arr[i]);
                    if(max == arr[i]) maxIndex = i;
                    min = Math.min(min, arr[i]);
                    if(min == arr[i]) minIndex = i;
                }
                arr[maxIndex] -= 1;
                arr[minIndex] += 1;
            }

            int max = 0; int min = 101;
            for(int i=0; i<100; i++) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            int answer = max-min;

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

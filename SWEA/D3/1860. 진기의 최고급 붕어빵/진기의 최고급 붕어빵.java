import java.io.*;
import java.util.*;

class Solution {
    static int n, m, k;
    static String answer;
    static int[] arr;
    public static void Solution() {
        int breadCount = 0;
        int time = -1;
        while(time<=arr[arr.length-1]) {
            time++;
            if(time>0 && time%m == 0) {
                breadCount += k;
            }
            for(int i : arr) {
                if(i == time) {
                    if (breadCount >= 1)
                        breadCount -= 1;
                    else {
                        answer = "Impossible";
                        return;
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());  //손님 수
            m = Integer.parseInt(st.nextToken());  //시간
            k = Integer.parseInt(st.nextToken());  //m초의 시간동안 k개의 붕어빵 만듦

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = "Possible";
            Solution();


            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

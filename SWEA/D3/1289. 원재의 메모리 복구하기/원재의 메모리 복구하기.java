import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[] arr;
    static int[] reset;
    public static void Solution() {
        while(!Arrays.equals(arr,reset)) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == 1 && reset[i] == 0) {
                    answer++;
                    for(int j=i; j<reset.length; j++) {
                        reset[j] = 1;
                    }
                }
                if(arr[i] == 0 && reset[i] == 1) {
                    answer++;
                    for(int j=i; j<reset.length; j++) {
                        reset[j] = 0;
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
            String[] str = br.readLine().split("");
            arr = new int[str.length];
            for(int i=0; i<str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            reset = new int[arr.length];
            answer = 0;
            Solution();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

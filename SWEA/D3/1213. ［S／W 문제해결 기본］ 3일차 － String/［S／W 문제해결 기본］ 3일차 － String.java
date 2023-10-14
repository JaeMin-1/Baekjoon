import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[][] arr;
    public static void Solution(String str, String[] sen) {
        for(int i=0; i<=sen.length-str.length(); i++) {
            String tmp = sen[i];
            for(int j=i+1; j<i+str.length(); j++) {
                tmp += sen[j];
            }
            if(str.equals(tmp)) answer++;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] sen = br.readLine().split("");
            answer = 0;
            Solution(str, sen);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

class Solution {
    static int[] num0 = {0, 0, 0, 1, 1, 0, 1};
    static int[] num1 = {0, 0, 1, 1, 0, 0, 1};
    static int[] num2 = {0, 0, 1, 0, 0, 1, 1};
    static int[] num3 = {0, 1, 1, 1, 1, 0, 1};
    static int[] num4 = {0, 1, 0, 0, 0, 1, 1};
    static int[] num5 = {0, 1, 1, 0, 0, 0, 1};
    static int[] num6 = {0, 1, 0, 1, 1, 1, 1};
    static int[] num7 = {0, 1, 1, 1, 0, 1, 1};
    static int[] num8 = {0, 1, 1, 0, 1, 1, 1};
    static int[] num9 = {0, 0, 0, 1, 0, 1, 1};
    static int[][] numbers = {num0, num1, num2, num3, num4, num5, num6, num7, num8, num9};
    static int[][] arr;
    static int[][] check;
    static ArrayList<Integer> code;
    static int n, m;
    static int answer;
    public static void Solution() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m-6; j++) {
                int[] tmp = new int[7];
                for(int k=0; k<7; k++) {
                    tmp[k] = arr[i][j+k];
                }
                for(int s=0; s<10; s++)
                    if(Arrays.equals(tmp, numbers[s])) code.add(s);
                if(code.size() == 1) { //암호의 첫 부분을 찾았을 때
                    for(int a=j+7; a<j+50; a+=7) {
                        int[] tmp2 = new int[7];
                        for(int k=0; k<7; k++) {
                            tmp2[k] = arr[i][a+k];
                        }
                        for(int s=0; s<10; s++)
                            if(Arrays.equals(tmp2, numbers[s])) code.add(s);
                    }
                    if(code.size() == 8) return;
                    else code = new ArrayList<>();
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            check = new int[n][m];
            for(int i=0; i<n; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<m; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            answer = 0;
            code = new ArrayList<>();
            Solution();
            if(((code.get(0)+code.get(2)+code.get(4)+code.get(6)) * 3 + code.get(1)+code.get(3)+code.get(5)+code.get(7) )% 10 == 0) {
                for(int i=0; i<8; i++) {
                    answer += code.get(i);
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

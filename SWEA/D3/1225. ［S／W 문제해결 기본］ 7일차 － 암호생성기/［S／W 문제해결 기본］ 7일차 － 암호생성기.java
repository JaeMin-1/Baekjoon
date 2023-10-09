import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static ArrayList<Integer> arr;
    public static void Solution() {
        while(true) {
            for(int i=1; i<=5; i++) {
                arr.add(arr.remove(0)-i);
                if(arr.get(7) <= 0) {
                    arr.set(7, 0);
                    return;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            for(int i=0; i<8; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution();

            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<8; i++) {
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

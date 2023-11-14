import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int p, q;
    static int answer;
    public static void Solution() {
        Point point1 = Ampersand(p);
        Point point2 = Ampersand(q);
        int x = point1.x + point2.x;
        int y = point1.y + point2.y;
        answer = Sharp(x,y);
    }

    public static int Sharp(int x, int y) {
        int k = x + y;
        int sum = 0;
        for(int i=1; i<=k-2; i++) {
            sum += i;
        }
        return sum + x;
    }

    public static Point Ampersand(int a) {
        int before = 1;
        int cnt = 0;
        while(true) {
            if(a-before > 0) {
                a -= before;
                before++;
                cnt++;
            }
            else break;
        }
        int x = a;
        int y = -a + cnt + 2;
        Point point = new Point(x,y);
        return point;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            answer = 0;
            Solution();


            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

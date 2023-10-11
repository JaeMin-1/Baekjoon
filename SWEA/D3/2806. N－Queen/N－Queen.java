import java.io.*;
import java.util.*;

class Point {
    int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int n;
    static ArrayList<Point> arr;
    static int answer;
    public static void DFS(int s) {
        if(s==n) answer++;
        else {
            for(int i=0; i<n; i++) {
                boolean flag = true;
                for(int j=0; j<arr.size(); j++) {
                    if(arr.get(j).x-s == arr.get(j).y-i || arr.get(j).x-s == -arr.get(j).y+i || arr.get(j).y == i) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    arr.add(new Point(s,i));
                    DFS(s+1);
                    arr.remove(arr.size()-1);
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
            n = Integer.parseInt(br.readLine());
            answer = 0;
            arr = new ArrayList<>();
            DFS(0);
            if(n == 1) answer = 1;

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

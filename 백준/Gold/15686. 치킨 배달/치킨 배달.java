import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, len;
    static int[][] arr;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();
    static int[] comb;
    static int answer = Integer.MAX_VALUE;
    public static void DFS(int L, int s) {
        if(L==m) {
            int sum = 0; // 도시의 치킨 거리
            for(Point hs : house) {
                int dis = Integer.MAX_VALUE; // 각 집마다 치킨 거리
                for(int i : comb) {
                    dis = Math.min(dis, Math.abs(hs.x-pizza.get(i).x)+Math.abs(hs.y-pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for(int i=s; i<len; i++) {
                comb[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) house.add(new Point(i,j));
                if(arr[i][j]==2) pizza.add(new Point(i,j));
            }
        }
        comb = new int[m];
        len = pizza.size();
        DFS(0, 0);
        System.out.println(answer);
    }
}

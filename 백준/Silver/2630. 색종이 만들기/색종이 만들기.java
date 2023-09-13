import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int blue = 0;
    static int white = 0;
    public static void Rec(int a, int b, int c, int d) {
        boolean one = false;
        boolean zero = false;
        for(int i=a; i<b; i++) {
            for(int j=c; j<d; j++) {
                if(map[i][j] == 1) one = true;
                if(map[i][j] == 0) zero = true;
            }
        }
        if(one == zero) { //1과 0이 섞여있으면 4개로 쪼개준다
            Rec(a, (a+b)/2, c, (c+d)/2); //2사분면
            Rec((a+b)/2, b, (c+d)/2, d); //4사분면
            Rec(a, (a+b)/2, (c+d)/2, d); //1사분면
            Rec((a+b)/2, b, c, (c+d)/2); //3사분면
        }
        else {
            if(one == true) blue++;
            if(zero == true) white++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Rec(0,n,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
}

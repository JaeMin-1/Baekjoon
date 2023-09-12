import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> Q = new LinkedList<>();
    static int[] ch = new int[100001];
    public static int BFS(int n, int k) {
        if(n==k) return 0;

        Q.offer(n);
        ch[n] = 1;
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                int x = Q.poll();
                int[] move = {-1, 1, x};
                for(int j=0; j<3; j++) {
                    if(x+move[j] >=0 && x+move[j]<=100000) {
                        int nx = x + move[j];
                        if(nx==k) return L+1;
                        if(nx>=0 && nx<=100000 && ch[nx] == 0) {
                            Q.offer(nx);
                            ch[nx] = 1;
                        }
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.print(BFS(n, k));

    }
}

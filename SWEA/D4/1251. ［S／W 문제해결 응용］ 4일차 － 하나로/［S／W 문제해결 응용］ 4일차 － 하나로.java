import java.io.*;
import java.util.*;

class Tunnel {
    int v1, v2;
    long cost;
    Tunnel(int v1, int v2, long cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

class Solution {
    static long answer;
    static int[] unf;
    static int[] x, y;
    static ArrayList<Tunnel> arr;
    public static int Find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            x = new int[n];
            y = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            double e = Double.parseDouble(br.readLine());
            answer = 0;
            unf = new int[n];
            for(int i=0; i<n; i++) unf[i] = i;
            arr = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    arr.add(new Tunnel(i,j,(long)(x[i]-x[j])*(x[i]-x[j]) + (long)(y[i]-y[j])*(y[i]-y[j])));
                }
            }
            Collections.sort(arr, (o1, o2) -> Long.compare(o1.cost, o2.cost));
            int cnt = 0;
            for(Tunnel ob : arr) {
                int fv1 = Find(ob.v1);
                int fv2 = Find(ob.v2);
                if(fv1!=fv2) {
                    answer += ob.cost;
                    Union(ob.v1, ob.v2);
                    cnt++;
                    if(cnt == n-1) break;
                }
            }
            sb.append("#").append(test_case).append(" ").append(Math.round(answer*e)).append("\n");
        }
        System.out.println(sb);
    }
}

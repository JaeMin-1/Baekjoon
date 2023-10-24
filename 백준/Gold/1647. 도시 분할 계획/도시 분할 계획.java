import java.io.*;
import java.util.*;

class Home {
    int v1, v2, cost;
    Home(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main {
    static int answer;
    static ArrayList<Home> arr;
    static int n, m;
    static int[] unf;
    public static int Find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;
        arr = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Home(a, b, c));
        }
        Collections.sort(arr, (o1, o2) -> {
            return o1.cost - o2.cost;
        });
        int cnt = 0;
        int bigCost = 0;
        for(Home ob : arr) {
            int fa = Find(ob.v1);
            int fb = Find(ob.v2);
            if(fa!=fb) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
                bigCost = ob.cost;
                cnt++;
                if(cnt == n-1) break;
            }
        }
        System.out.println(answer-bigCost);
    }
}

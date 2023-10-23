import java.io.*;
import java.util.*;

class Edge {
    int v1, v2, cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main {
    static int[] unf;
    static ArrayList<Edge> arr = new ArrayList<>();
    public static int Find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        unf = new int[v+1];
        for(int i=1; i<=v; i++) unf[i] = i;
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a, b, c));
        }
        int answer = 0;
        Collections.sort(arr, (o1, o2) -> {return o1.cost - o2.cost;});
        for(Edge ob : arr) {
            int Fa = Find(ob.v1);
            int Fb = Find(ob.v2);
            if(Fa!=Fb) {
                answer += ob.cost;
                Union(Fa, Fb);
            }
        }
        System.out.println(answer);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++)
            q.offer(i);

        System.out.print("<");

        while(q.size()>1) {
            for(int i=1; i<K; i++) {
                q.offer(q.poll());
            }
            System.out.print(q.poll() + ", ");
        }
        System.out.print(q.poll() + ">");
    }
}

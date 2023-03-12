import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(q.isEmpty()) sb.append(0).append('\n');
                else sb.append(q.poll()).append('\n');
            }
            else q.add(x);
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            for(int a=0; a<N; a++) {
                q.offer(new int[] { a, Integer.parseInt(st.nextToken()) });
            }

            int cnt = 0;
            while(q.size() > 0) { 
                boolean isMax = true;
                for(int j=1; j<q.size(); j++) {
                    if(q.get(0)[1] < q.get(j)[1]) {
                        for(int k=0; k<j; k++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(isMax == false) continue;

                cnt++;
                if (q.get(0)[0] == M) {
                    System.out.println(cnt);
                    break;
                }
                q.poll();
            }
        }
    }
}

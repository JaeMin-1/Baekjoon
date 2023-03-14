import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        while(K > 0) {
            if(K >= arr[N-1]) {
                    cnt += K / arr[N-1];
                    K %= arr[N-1];
            }
            N--;
        }
        System.out.println(cnt);
    }
}

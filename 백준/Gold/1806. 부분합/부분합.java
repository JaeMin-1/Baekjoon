import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int cnt = 0;
        int lt = 0;
        for(int rt=0; rt<n; rt++) {
            sum += arr[rt];
            cnt++;
            if(sum >= s) answer = Math.min(answer, cnt);
            while(sum >= s) {
                sum -= arr[lt++];
                cnt--;
                if(sum >= s) answer = Math.min(answer, cnt);
            }

        }
        if(answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);

    }
}

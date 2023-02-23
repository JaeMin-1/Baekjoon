import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i=0; i<N; i++) {
            boolean isPrime = true;
            if(arr[i] == 1) continue;
            
            for(int j=2; j<arr[i]; j++) {
                if(arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) cnt++;
        }
        System.out.println(cnt);
    }
}

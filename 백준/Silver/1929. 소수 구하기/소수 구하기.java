import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N-M+1];
        arr[0] = M;
        for(int i=1; i<=N-M; i++) {
            arr[i] = arr[i-1] + 1;
        }

        for(int i=0; i<N-M+1; i++) {
            boolean isPrime = true;
            if(arr[i] == 1) continue;

            for(int j=2; j<=Math.sqrt(arr[i]); j++) {
                if(arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) System.out.println(arr[i]);
        }
    }
}

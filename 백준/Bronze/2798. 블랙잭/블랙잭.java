import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int diff = M;
        Loop:
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    if(arr[i] + arr[j] + arr[k] == M) {
                        diff = 0;
                        break Loop;
                    }
                    else if(arr[i] + arr[j] + arr[k] < M) {
                        if(M - (arr[i] + arr[j] + arr[k]) < diff) {
                            diff = M - (arr[i] + arr[j] + arr[k]);
                        }
                    }
                }
            }
        }
        System.out.println(M-diff);
    }
}

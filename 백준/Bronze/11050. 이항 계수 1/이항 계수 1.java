import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a = 1, b = 1, c = 1;
        for(int i=N; i>0; i--) {
            a *= i;
        }
        for(int i=K; i>0; i--) {
            b *= i;
        }
        for(int i=N-K; i>0; i--) {
            c *= i;
        }

        System.out.println(a/(b*c));


    }
}

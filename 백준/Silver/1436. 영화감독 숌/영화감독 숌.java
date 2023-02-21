import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 666;
        int cnt = 1;
        while(cnt != N) {
            a++;
            if(Integer.toString(a).contains("666")) {
                cnt++;
            }
        }
        System.out.println(a);


    }
}

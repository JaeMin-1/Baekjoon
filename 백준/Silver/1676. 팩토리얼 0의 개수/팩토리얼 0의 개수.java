import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt_2 = 0;
        int cnt_5 = 0;
        for(int i=1; i<=N; i++) {
            int fac = i;
            while(fac % 2 == 0) {
                fac /= 2;
                cnt_2++;
            }
            while(fac % 5 == 0) {
                fac /= 5;
                cnt_5++;
            }
        }
        System.out.println(Math.min(cnt_2, cnt_5));

    }
}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        if(X==1) System.out.println(1 + "/" + 1);
        else if(X==2) System.out.println(1 + "/" + 2);
        else {
            int num = X;
            int cnt = 0;
            for(int i=1; i<X; i++) {
                if(num<=i) {
                    cnt++;
                    break;
                }
                num -= i;
                cnt++;
            }

            if(cnt % 2 != 0) System.out.println((cnt - num + 1) + "/" + num);
            if(cnt % 2 == 0) System.out.println(num + "/" + (cnt - num + 1));
        }

    }
}

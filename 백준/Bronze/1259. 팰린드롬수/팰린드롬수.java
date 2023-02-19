import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = new String(br.readLine());
            if(str.equals("0")) break;

            boolean check = true;
            for(int i=0; i<str.length()/2; i++) {
                if(str.charAt(i) != (str.charAt(str.length()-i-1))) {
                    check = false;
                    break;
                }
            }
            if(check == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

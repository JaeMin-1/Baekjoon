import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder  sb = new StringBuilder();
        int bitset = 0;

        while(M-- > 0) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            switch(command) {
                case "add":
                    bitset |= (1 << (x));
                    break;
                case "remove":
                    bitset &= ~(1 << x);
                    break;
                case "check":
                    sb.append((bitset & (1 << x)) == 0 ? 0 : 1).append('\n');
                    break;
                case "toggle":
                    bitset ^= (1 << x);
                    break;
                case "all":
                    bitset |= ~0;
                    break;
                case "empty":
                    bitset &= 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}

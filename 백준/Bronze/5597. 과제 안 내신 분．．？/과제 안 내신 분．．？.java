import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] chk = new boolean[31];

        for(int i=0; i<28; i++)
            chk[Integer.parseInt(br.readLine())] = true;

        for(int i=1; i<=30; i++)
            if(!chk[i]) System.out.println(i);
    }
}

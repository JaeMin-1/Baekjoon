import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] pieces = {1, 1, 2, 2, 2, 8};
        int[] input = new int[6];
        
        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            System.out.print((pieces[i] - input[i]) + " ");
        }
    }
}

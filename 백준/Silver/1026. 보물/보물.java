import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);

        int[] B2 = new int [N];
        for(int i=0; i<N; i++)
            B2[i] = B[N-i-1];

        int S = 0;
        for(int i=0; i<N; i++)
            S += A[i] * B2[i];

        System.out.println(S);
    }
}

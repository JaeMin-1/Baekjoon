import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (e1, e2) -> {   
            return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
        });

        for(int i=0; i<N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[][] = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            return e1[1] - e2[1];                //이중배열 두번째 원소에 대한 오름차순 정렬
        });

        int sum = 0;
        for(int i=1; i<=N; i++) {
            sum += arr[i][1] * (N - i + 1);
        }
        System.out.println(sum);
    }
}

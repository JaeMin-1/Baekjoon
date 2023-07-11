import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int answer = 0;
        int lt = 0, rt = n-1;
        while(lt<rt) {
            if(arr[lt] + arr[rt] == x) {
                answer++;
                lt++; rt--;
            }
            else if(arr[lt] + arr[rt] > x) {
                rt--;
            }
            else lt++;
        }
        System.out.print(answer);




    }
}

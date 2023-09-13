import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n==0) System.out.println(0);
        else {
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int num = (int)Math.round(n*0.15);
            int sum = 0;
            for(int i=num; i<n-num; i++) {
                sum += arr[i];
            }
            int aver = (int)Math.round((double)sum/(n-(2*num)));
            System.out.println(aver);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> cnt = new ArrayList<>();
        int answer_num = 0, sum = 0;
        for(int i=0; i<x; i++) {
            sum += arr[i];
        }
        answer_num = sum;
        cnt.add(sum);
        for(int i=x; i<n; i++) {
            sum += arr[i] - arr[i - x];
            cnt.add(sum);
            answer_num = Math.max(answer_num, sum);
        }
        
        int answer_cnt = 0;
        for(int num : cnt) {
            if(num == answer_num) answer_cnt++;
        }

        if(answer_num == 0) System.out.println("SAD");
        else {
            System.out.println(answer_num);
            System.out.println(answer_cnt);
        }






    }
}

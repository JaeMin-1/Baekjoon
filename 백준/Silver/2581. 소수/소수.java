import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int first = 0;
        int sum = 0;

        for(int i=N; i<=M; i++) {
            int num = isPrime(i);
            if(sum == 0) first = num;   //sum이 0일때, 즉 처음 등장한 소수일때 first에 저장
            sum += num;
        }

        if(sum != 0) {   //소수가 하나라도 있다면
            System.out.println(sum);
            System.out.println(first);
        }
        else System.out.println(-1);
    }

    public static int isPrime(int num) {
        if(num == 1) return 0;
        
        for(int i=2; i<num; i++) {
            if(num % i == 0) return 0;   //소수가 아니라면 sum에 더해지면 안되므로 0을 출력
        }
        return num;
    }
}

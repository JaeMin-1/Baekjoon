import java.io.*;
import java.util.*;

public class Main {
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(make_1(N));
    }

    //조건문마다 +1 이 붙은 것은 dp에 연산횟수를 저장하기 위함이다. 다음 재귀로 넘어가면서 이전 계산에 대한 횟수를 증가시키는 것.
    //꼭대기 노드에서 밑으로 한층씩 내려가면서 횟수를 +1씩 하며 나중에 N=1일때 그동안의 +1들이 총 연산횟수가 된다.
    public static int make_1(int N) {
        if(dp[N] == null) {
            if(N % 6 == 0)
                dp[N] = Math.min(make_1(N-1),Math.min(make_1(N/2),make_1(N/3))) + 1;
            else if(N % 3 == 0)
                dp[N] = Math.min(make_1(N / 3), make_1((N - 1))) + 1;
            else if (N % 2 == 0)
                dp[N] = Math.min(make_1(N / 2), make_1(N - 1)) + 1;
            else
                dp[N] = make_1(N-1) + 1;
        }
        return dp[N];
    }
}

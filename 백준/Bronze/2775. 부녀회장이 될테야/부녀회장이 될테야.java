import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static int[][] arr = new int[15][15]; //0~14층:15개, 1~14호 + 맨앞 그냥 비워두기 :15개

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=14; i++) {
            arr[0][i] = i;
        }

        while(T != 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int ans = search(k, n);
            System.out.println(ans);
            T--;
        }
    }
    public static int search(int a, int b) {
        int sum = 0;
        if(a == 0) return arr[a][b];
        else {
            for(int i=b; i>=1; i--) {
                sum += search(a-1,i);
            }
            return sum;
        }
    }
}

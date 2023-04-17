import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(0, 0, (int) Math.pow(2, N));
    }

    public static void solve(int x, int y, int n) {
        if (n == 1) {
            System.out.println(count);
            return;
        }

        int size = n / 2;
        if (r < x + size && c < y + size) {
            solve(x, y, size);
        } else if (r < x + size && c >= y + size) {
            count += size * size;
            solve(x, y + size, size);
        } else if (r >= x + size && c < y + size) {
            count += 2 * size * size;
            solve(x + size, y, size);
        } else {
            count += 3 * size * size;
            solve(x + size, y + size, size);
        }
    }
}

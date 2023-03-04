import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for(int i=1; i<=N; i++) {
            stack.push(i);
            sb.append('+').append('\n');

            while(!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
                sb.append('-').append('\n');
            }
        }

        if(!stack.isEmpty())
            System.out.println("NO");
        else System.out.println(sb);
    }
}

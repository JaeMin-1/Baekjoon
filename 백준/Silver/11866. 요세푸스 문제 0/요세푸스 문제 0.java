import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        while(list.size()!=0) {
            cnt += K - 1;
            if(cnt >= list.size()) {
                cnt %= list.size();
            }
            result.add(list.get(cnt));
            list.remove(cnt);
        }
        System.out.print("<");
        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i));
            if(i!=result.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");

    }
}

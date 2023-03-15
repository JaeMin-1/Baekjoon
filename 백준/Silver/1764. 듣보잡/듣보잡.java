import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set  = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String str = br.readLine();       //br.readLine()을 바로 사용하지 않고, str로 정의해주고 str로 사용해야 출력이 제대로 됐다.
            if (set.contains(str)) {          //br.readLine()을 contains 와 add에 각각 바로 넣는다면, 의도와는 다르게 두 번 읽기 때문이다.
                result.add(str);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(String str : result) {
            System.out.println(str);
        }




    }
}


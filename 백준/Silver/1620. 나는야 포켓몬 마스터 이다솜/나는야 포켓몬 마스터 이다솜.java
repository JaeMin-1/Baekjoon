import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            map1.put(str, i);
            map2.put(i, str);
        }

        while(M-- > 0) {
            String str = br.readLine();
            if(Character.isLetter(str.charAt(0)))
                System.out.println(map1.get(str));
            else System.out.println(map2.get(Integer.parseInt(str)));
        }

    }

}

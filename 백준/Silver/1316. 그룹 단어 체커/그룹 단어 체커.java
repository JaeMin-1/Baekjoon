import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(N-- > 0) {
            String str = br.readLine();
            boolean[] visited = new boolean[26];
            boolean check = true;

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                //만약 새로운 알파벳이 들어온다면 visited 배열에서 알맞은 자리를 true로 변경
                if(!visited[c-'a'])
                    visited[c-'a'] = true;

                //새로운 알파벳이 아니며 또 들어왔다면
                else
                    //그 알파벳이 바로 직전 알파벳과 다르다면
                    if (str.charAt(i-1) != c) {
                        //기존에 있던 알파벳이 연속되지 않은 차례에 다시 등장했으니 그룹단어가 아니라는 false를 입력하고 break.
                        check = false;
                        break;
                    }
            }

            //check가 true라는 것은 기존 알파벳이 다시 안들어왔거나, 들어오더라도 직전 알파벳과 같다는 뜻. 즉 그룹단어
            if(check) cnt++;
        }
        System.out.println(cnt);

    }
}

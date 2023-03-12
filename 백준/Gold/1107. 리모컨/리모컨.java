import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] btn = new boolean[10];  //초기값은 false
    public static int len = 0;                      //ch의 자릿수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //타겟 체널 번호
        int M = Integer.parseInt(br.readLine()); //고장난 버튼 개수

        if(M != 0)  {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int numBtn = Integer.parseInt(st.nextToken());
                btn[numBtn] = true;                  //true가 고장난 버튼
            }
        }

        int ans = Math.abs(N - 100);             //초기값은 +,-버튼만으로 채널이동하는 경우

        for(int i=0; i<=999999; i++) {
            int ch = i;
            boolean pos = possible(ch);

            if(pos == true) {
                int press = Math.abs(N - ch);    //ch에서는 오로지 +,-버튼만으로 N에 도달한다.
                if(ans > press + len) {
                    ans = press + len;           //만약 ch까지 이동후 ch에서 N까지 이동한 총 합이 ans보다 작다면 ans 변경, 이 방법으로 최소 버튼 수 찾기
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean possible(int ch) {
        len = 0;                                        //possible함수를 실행할때마다 len을 초기화해줘야한다. 그렇지 않으면 기존 계산된 len으로 인해
                                                        //본인의 자릿수보다 큰 len을 얻게되서 문제가 발생한다.
        if(ch == 0)
            if(btn[0] == true) return false;            //0번이 고장났으면(true면) false 리턴. 즉 possible하지 않다.
            else {
                len++;                                  //ch가 0일때 한자릿수이므로 자릿수를 하나 더해줘야한다. 0번 버튼을 한번눌러서 0번으로 가기때문.
                return true;
            }

        while(ch != 0) {
            if(btn[ch%10] == true) return false;        //고장난 버튼이 있다면 possible하지 않다.
            else  {
                ch /= 10;                               //자릿수마다 전부 조사
                len++;                                  //몇자리인지 알아야 리모컨 버튼을 몇번 누를지 알 수 있다.(ex. 967번이면 9,6,7 3번 눌려야함)
            }
        }

        return true;                                    //위 과정을 통과했다는건 possible하다는 뜻.
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (e1, e2) -> {         //끝나는 시간 기준으로 오름차순 정렬
            if(e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
        });

        int cnt = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<N; i++) {
            if(start <= time[i][0]) {          //가능한 시작시간이 특정 시간표의 시작보다 빠르거나 같다면
                end = time[i][1];              //이 시간표는 가능하므로 채택, 끝나는시간을 이 시간표의 끝나는 시간으로 지정
                start = end;                   //이 시간표가 끝나는 시간이 다시 새로운 시작 가능한 시간이 되며 다시 재탐색
                cnt++;                         //가능한 시간표 개수 추가
            }

        }

        System.out.println(cnt);
    }
}

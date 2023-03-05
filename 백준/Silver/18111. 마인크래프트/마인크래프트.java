import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = -1;
        for(int h=minHeight; h<=maxHeight; h++) { //가장 낮은 높이부터 높은 높이까지 평평화 목표 높이를 증가시키며 탐색
            int time = 0;
            int inventory = B;
            boolean possible = true;

            for(int i=0; i<N; i++) {              //목표 높이 h에 대해 평평화 작업을 시작하는 for문
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;
                    if (diff > 0) {                //기존 높이가 목표 높이보다 크다면
                        time += 2 * diff;         //블럭을 제거해야하므로 2초씩 걸림
                        inventory += diff;        //인벤토리에 제거했던 블럭이 추가됨
                    }
                }
            }
            //앞선 for문에서 추가할 블럭을 먼저 다 추가해주고 블럭 제거 for문은 아래와 같이 다시 따로 돌리는게 맞음
            //왜냐하면 좌표를 순차적으로 제거 및 추가를 하다보면 뒷순서에서 제거해야할 블럭이 있어서 쌓을 블럭의 여유가 있음에도 불구하고
            //먼저 쌓아야하는 경우가 생겨서 현 인벤토리에 블럭이 없으므로 그냥 끝내버림
            //따라서 먼저 인벤토리에 블럭을 다 저장하고 이후에 블럭을 쌓는 순서로 가야함
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int diff = map[i][j] - h;
                    if(diff < 0) {                //기존 높이가 목표 높이보다 작다면(diff가 음수이므로 -diff로 진행해야함
                        if(inventory >= -diff) {  //블럭을 목표 높이보다 작은만큼 쌓아야하는데 인벤토리에 있는지 확인
                            time += -diff;        //인벤토리에 충분히 있으면 블럭을 쌓는데 1초씩 걸림
                            inventory -= -diff;   //인벤토리에서는 블럭이 높이 차이만큼 빠짐
                        }
                        else {                    //인벤토리에 쌓아야할 블럭의 개수가 없으면
                            possible = false;     //쌓을 수 없다고 알림
                            break;                //현 목표 높이에 대해서는 평평화할 수 없으므로 바로 break
                        }
                    }
                }
                if (!possible) break;             //M에 대해 break은 했으니 이번엔 N에 대해 break
            }
            //여기까지 왔다는건 위에서의 목표 높이에 대해 평평화 작업이 가능하다는 뜻
            if(possible && time <= ansTime) {     //possible하고 전의 다른 목표 높이보다 시간이 덜 걸리거나 같다면
                ansTime = time;                   //시간 갱신
                ansHeight = h;                    //높이 갱신(진행될수록 목표 높이가 높아지므로 시간이 같으면 더 높은 높이로 당연히 갱신)
            }
        }
        System.out.println(ansTime + " " + ansHeight);
    }
}

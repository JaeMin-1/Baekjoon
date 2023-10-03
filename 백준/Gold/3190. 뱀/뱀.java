import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 }; // 동 남 서 북
    static int[][] arr;
    static int n, k, L;
    static int answer = 0;
    static ArrayList<Point> snake = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        snake.add(new Point(1,1)); //초기화
        int d = 0;
        int time = 0;
        Loop:
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            for(int j=time; j<a; j++) {
                int nx = snake.get(snake.size()-1).x + dx[d];
                int ny = snake.get(snake.size()-1).y + dy[d];

                for(Point p : snake) { //몸통 만났을때 종료
                    if(p.x == nx && p.y == ny) {
                        time++;
                        break Loop;
                    }
                }

                if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
                    if (arr[nx][ny] == 1) {  //사과 만났을 때
                        arr[nx][ny] = 0;
                        snake.add(new Point(nx, ny));
                        time++;
                    }
                    else { //빈 칸 만났을 때
                        snake.add(new Point(nx, ny));
                        snake.remove(0);
                        time++;
                    }
                }
                else {  //벽 만났을 때 종료
                    time++;
                    break Loop;
                }

                if(time == a) {
                    if(c == 'D') {
                        if(d!=3) d++;
                        else d = 0;
                    }
                    if(c == 'L') {
                        if(d!=0) d--;
                        else d = 3;
                    }
                }

                if(i == L-1 && time == a) {
                    while(true) {
                        nx = snake.get(snake.size()-1).x + dx[d];
                        ny = snake.get(snake.size()-1).y + dy[d];

                        for(Point p : snake) { //몸통 만났을때 종료
                            if(p.x == nx && p.y == ny) {
                                time++;
                                break Loop;
                            }
                        }

                        if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
                            if (arr[nx][ny] == 1) {  //사과 만났을 때
                                arr[nx][ny] = 0;
                                snake.add(new Point(nx, ny));
                                time++;
                            }
                            else { //빈 칸 만났을 때
                                snake.add(new Point(nx, ny));
                                snake.remove(0);
                                time++;
                            }
                        }
                        else {  //벽 만났을 때 종료
                            time++;
                            break Loop;
                        }
                    }
                }
            }
        }
        System.out.println(time);
    }
}

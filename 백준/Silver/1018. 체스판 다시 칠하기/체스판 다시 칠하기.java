import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int min = 64;
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                int cnt = 0;
                for(int k=i; k<i+8; k++) {
                    for(int l=j; l<j+8; l++) {
                        if((k+l) % 2 == 0) {
                            if(arr[k][l] != 'W') {
                                cnt++;
                            }
                        } else {
                            if(arr[k][l] != 'B') {
                                cnt++;
                            }
                        }
                    }
                }
                min = Math.min(min, Math.min(cnt, 64 - cnt));
            }
        }
        System.out.println(min);
    }
}

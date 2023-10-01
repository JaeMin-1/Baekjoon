import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(arr[r][c] == 0) arr[r][c] = 2;
            else if(arr[r+1][c]!=0 && arr[r-1][c]!=0 && arr[r][c+1]!=0 && arr[r][c-1]!=0) {
                if(d==0) {
                    if(arr[r+1][c]!=1) r+=1;
                    else break;
                }
                if(d==1) {
                    if(arr[r][c-1]!=1) c-=1;
                    else break;
                }
                if(d==2) {
                    if(arr[r-1][c]!=1) r-=1;
                    else break;
                }
                if(d==3) {
                    if(arr[r][c+1]!=1) c+=1;
                    else break;
                }
            }
            else if(arr[r+1][c]==0 || arr[r-1][c]==0 || arr[r][c+1]==0 || arr[r][c-1]==0) {
                if(d==0) {
                    d = 3;
                    if(arr[r][c-1]==0) c-=1;
                }
                else if(d==1) {
                    d = 0;
                    if(arr[r-1][c]==0) r-=1;
                }
                else if(d==2) {
                    d = 1;
                    if(arr[r][c+1]==0) c+=1;
                }
                else if(d==3) {
                    d = 2;
                    if(arr[r+1][c]==0) r+=1;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 2) answer++;
            }
        }
        System.out.println(answer);
    }
}

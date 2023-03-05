import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int left = 0;
        int right = arr[N-1];
        while(left<=right) {
            int mid = (left+right)/2;
            long sum = 0;
            for(int i=0; i<N; i++) {
                if(arr[i]>mid)               //나무의 높이가 절단기 설정 높이보다 크면
                    sum += arr[i] - mid;     //그 나무를 베었을때 가져갈 수 있는 나무의 길이를 더한다.
            }
            if(sum >= M)                     //잘린 나무 길이의 합이 필요한 나무 길이보다 크면
                left = mid + 1;              //절단기 높이를 높여서 더 적게, 필요한 길이에 가깝게 잘라본다
            else                             //잘린 나무 길이의 합이 필요한 나무 길이보다 작으면
                right = mid - 1;             //절단기 높이를 낮춰서 더 많이, 필요한 길이에 가깝게 잘라본다
        }
        System.out.println(right);
    }


}

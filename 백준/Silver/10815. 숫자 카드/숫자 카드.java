import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, number)) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;   // 타겟을 찾은 경우 true를 반환
            } else if (arr[mid] < target) {
                left = mid + 1;   // mid 보다 큰 범위에서 찾음
            } else {
                right = mid - 1;  // mid 보다 작은 범위에서 찾음
            }
        }
        return false;   // 타겟을 찾지 못한 경우 false을 반환
    }

}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //산술평균
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
        }
        double avg = (double)sum / N;
        System.out.println(Math.round(avg));
        //중앙값
        int middle = arr[N/2];
        System.out.println(middle);
        //최빈값
        //카운팅 배열 생성 후 arr 원소 카운트해서 +해주기
        int cnt[] = new int[8001];
        for(int i=0; i<N; i++)
            cnt[arr[i]+4000]++;
        //가장 높은 빈도수를 MaxFreq에 저장
        int MaxFreq = 0;
        for(int i=0; i<8001; i++) {
            if(MaxFreq < cnt[i])
                MaxFreq = cnt[i];
        }
        //MaxFreq로 조건에 맞게 가장 큰 값, 두번째로 큰 값 출력
        ArrayList<Integer> mode = new ArrayList<>();
        for(int i=0; i<8001; i++) {
            if(cnt[i] == MaxFreq)
                mode.add(i-4000);
        }
        Collections.sort(mode);
        if(mode.size() > 1)
            System.out.println(mode.get(1));
        else
            System.out.println(mode.get(0));
        //범위
        int range = arr[N-1] - arr[0];
        System.out.println(range);
    }
}

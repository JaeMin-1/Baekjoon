import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[4];
        for(int i=0; i<4; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        array[2] = array[2] - array[0];
        array[3] = array[3] - array[1];

        int min = array[0];
        for(int num : array) {
            if(num<min) {
                min = num;
            }
        }

        System.out.println(min);
    }
}

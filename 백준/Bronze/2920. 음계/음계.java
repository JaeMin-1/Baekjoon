import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[8];
        for(int i=0; i<8; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        if(array[0] == 1) {
            for(int i=1; i<8; i++) {
                if(array[i-1] + 1 != array[i]) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        }
        else if(array[0] == 8) {
            for(int i=1; i<8; i++) {
                if(array[i-1] != array[i] + 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        }
        else if(array[0] != 1 && array[0] != 8) {
            System.out.println("mixed");
        }
    }
}

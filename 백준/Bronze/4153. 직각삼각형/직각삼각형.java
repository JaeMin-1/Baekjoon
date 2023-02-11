import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            if(x == 0 && y == 0 && z == 0) break;
            
            else if(x>=y && x>=z) {
                if(x*x == y*y + z*z) {
                    System.out.println("right");
                }
                else System.out.println("wrong");
            }
            
            else if(y>=x && y>=z) {
                if(y*y == x*x + z*z) {
                    System.out.println("right");
                }
                else System.out.println("wrong");
            }
            
            else if(z>=x && z>=y) {
                if(z*z == x*x + y*y) {
                    System.out.println("right");
                }
                else System.out.println("wrong");
            }
        }
    }
}

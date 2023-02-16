import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int[] arr = new int[2000001];	
        
		int N = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = 1;
		}
 
		for(int i = 0; i < 2000001; i++) {
			if(arr[i]==1) {
				sb.append((i - 1000000)).append('\n');
			}
		}
		System.out.print(sb);
	}
}
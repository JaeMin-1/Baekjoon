import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (String s1, String s2) -> {
            if(s1.length() == s2.length()) return s1.compareTo(s2);
            else return s1.length() - s2.length();
        });

        System.out.println(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(!arr[i-1].equals(arr[i]))
                System.out.println(arr[i]);
        }
    }
}

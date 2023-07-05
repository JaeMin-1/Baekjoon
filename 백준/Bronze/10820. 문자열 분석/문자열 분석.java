import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            int cnt1=0, cnt2=0, cnt3=0, cnt4=0;
            for(int i=0; i<str.length(); i++) {
                if(Character.isLowerCase(str.charAt(i))) cnt1++;
                if(Character.isUpperCase(str.charAt(i))) cnt2++;
                if(Character.isDigit(str.charAt(i))) cnt3++;
                if(str.charAt(i) == ' ') cnt4++;
            }
            System.out.println(cnt1 + " " + cnt2 + " " + cnt3 + " " + cnt4);
        }
    }
}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = str.length();               //첫 입력값이 팰린드롬이라면 ans는 그대로 문자열의 길이가 출력됨

        for(int i=0; i<str.length(); i++) {         //첫 서브스트링, 즉 전체스트링부터 마지막 서브스트링, 즉 마지막 문자하나까지 탐색
            if (check(str.substring(i))) {          //서브스트링이 팰린드롬이라면
                //str은 팰린드롬이 되기위해 서브스트링이 아닌 부분(=왼쪽부분)만큼 길이를 추가해줘야한다.
                ans += str.length() - str.substring(i).length();
                break;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start<=end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

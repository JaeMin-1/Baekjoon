import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int answer;
    public static void Solution(String str) {
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(' || c == '[' || c == '{' || c == '<') s.push(c);
            if(c == ')' && !s.isEmpty()) {
                if(s.peek() == '(') s.pop();
                else return;
            }
            if(c == ']' && !s.isEmpty()) {
                if(s.peek() == '[') s.pop();
                else return;
            }
            if(c == '}' && !s.isEmpty()) {
                if(s.peek() == '{') s.pop();
                else return;
            }
            if(c == '>' && !s.isEmpty()) {
                if(s.peek() == '<') s.pop();
                else return;
            }
        }
        answer = 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            answer = 0;
            Solution(str);
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            System.out.println(balance(str));
        }
    }

    public static String balance(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(' || c == '[') stack.push(c);

            else if(c == ')') {
                if(stack.empty() || stack.peek() != '(') return "no";
                else stack.pop();
            }
            else if(c == ']') {
                if(stack.empty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }

        if(stack.empty()) return "yes";
        else return "no";
    }
}

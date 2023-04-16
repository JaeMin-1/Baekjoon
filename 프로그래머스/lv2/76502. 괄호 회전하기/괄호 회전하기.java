import java.util.*;
import java.io.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        int cnt = sb.length();
        while(cnt-->0) {
            sb.append(sb.charAt(0)).deleteCharAt(0);
            
            boolean right = true;
            Stack<Character> stack = new Stack<>();
            for(int j=0 ; j<sb.length(); j++) {
                if(sb.charAt(j) == '[' || sb.charAt(j) == '(' || sb.charAt(j) == '{') {
                    stack.push(sb.charAt(j));
                }
                else if(sb.charAt(j) == ']') 
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        right = false;
                        break;
                    }
                else if(sb.charAt(j) == ')') 
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        right = false;
                        break;
                    }
                else if(sb.charAt(j) == '}') 
                    if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else {
                        right = false;
                        break;
                    }
            }
            if(stack.isEmpty() && right) answer++;
        }
        return answer;
    }
}
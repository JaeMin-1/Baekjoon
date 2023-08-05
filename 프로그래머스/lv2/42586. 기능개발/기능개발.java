import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> Q = new LinkedList<>();
        for(int i =0; i<progresses.length; i++) {
            int rest = 100 - progresses[i];
            int day = rest / speeds[i];
            if(rest % speeds[i] != 0) day++;
            Q.offer(day);
        }
        
        ArrayList<Integer> tempAns = new ArrayList<>();
        while(!Q.isEmpty()) {
            int tmp = Q.poll();
            int cnt = 1;
            while(!Q.isEmpty() && Q.peek() <= tmp) {
                Q.poll();
                cnt++;
            }
            tempAns.add(cnt);
        }
        
        int[] answer = new int[tempAns.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempAns.get(i);
        }
        
        return answer;
    }
}
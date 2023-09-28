import java.util.*;
import java.io.*;

class Process {
    int prior;
    int num;
    public Process(int prior, int num) {
        this.prior = prior;
        this.num = num;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> Q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            Q.offer(new Process(priorities[i], i));
        }
        while(!Q.isEmpty()) {
            boolean most = true;
            Process tmp = Q.poll();
            for(Process pro : Q) {
                if(tmp.prior<pro.prior) {
                    Q.offer(tmp);
                    most = false;
                    break;
                }  
            }
            if(most) {
                if(tmp.num == location) return answer;
                else answer++;
            }
        }
        
        return answer;
    }
}
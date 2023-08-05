import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int preNum = Integer.MAX_VALUE;
        for(int num : arr) {
            if(preNum != num) {
                tempList.add(num);
                preNum = num;    
            }
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}

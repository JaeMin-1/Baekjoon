class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(!s.equals("1")) {
            int len = s.length();
            s = s.replace("0","");
            answer[1] += len - s.length();
        
            int num = s.length();
            s = Integer.toBinaryString(num);
            answer[0]++;
        }  
        return answer;
    }
}
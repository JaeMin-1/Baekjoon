class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        StringBuilder sb = new StringBuilder(s);
        while(!sb.toString().equals("1")) {
            for(int i=0; i<sb.length(); i++) {
                if(sb.charAt(i) == '0') {
                    sb.deleteCharAt(i);
                    answer[1]++;
                    i--;
                }
            }
            
            int num = sb.length();
            sb = new StringBuilder(Integer.toBinaryString(num));
            answer[0]++;
        }  
        return answer;
    }
}
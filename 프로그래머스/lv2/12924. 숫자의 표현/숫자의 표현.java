class Solution {
    public int solution(int n) {
        int answer = 0;
        //int number = n;
        for(int a=n; a>=1; a--) {
            int num = n;
            for(int i=a; i>=1; i--) {
                num -= i;
                if(num == 0) {
                    answer++;
                    break;
                }
                if(num<0) break;
            }   
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        String bin = Integer.toBinaryString(n);
        bin = bin.replace("0","");
        
        for(int i=n+1; i<2*n; i++) {
            String bin2 = Integer.toBinaryString(i);
            String bin3 = bin2.replace("0","");
            if(bin3.length() == bin.length()) {
                answer = Integer.parseInt(bin2, 2);
                break;
            }
        }
        return answer;
    }
}
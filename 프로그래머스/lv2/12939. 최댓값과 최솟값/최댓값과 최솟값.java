class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int [] arr = new int[strArr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        int max = arr[0];
        int min = arr[0];
        for(int k : arr) {
            if(k>max) max = k;
            if(k<min) min = k;
        }
        answer = min + " " + max;
        return answer;
    }
}
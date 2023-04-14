class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        
        for(String word : words) {
            if(word.length() == 0) answer += " ";  //다음에 올 문자를 위한 공백
            else {
                answer += word.substring(0,1).toUpperCase();  //첫 문자 대문자
                answer += word.substring(1).toLowerCase();    //남은 문자 소문자
                answer += " ";  //다음에 올 문자를 위한 공백
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}
        return answer.substring(0, answer.length()-1);
        
        //return words[0];
        //return words[words.length-1];
        //맨앞에 공백이 있다면 split(" ") 했을때 배열의 처음 원소는 ""이지만, 맨뒤에 공백이 있다면 split(" ") 했을때 배열의 마지막 원소는 ""이 아닌, 그전의 문자값이다. 즉 뒤에 공백이 아무리 길어봤자 배열의 마지막원소는 마지막 문자값이다.
    }
}
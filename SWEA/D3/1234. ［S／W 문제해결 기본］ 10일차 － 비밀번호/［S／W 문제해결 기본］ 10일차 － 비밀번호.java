import java.io.*;
import java.util.*;

class Solution
{	
	static int n;
	static String answer;
	static ArrayList<Character> arr; 
	public static void solution() {
		int i = 0;
		while(i+1<arr.size()) {
			if(arr.get(i) == arr.get(i+1)) {
				arr.remove(i);
				arr.remove(i);
				i = 0;
			}
			else i++;
		}
		for(char c : arr) {
			if(c != 'a') {
				answer += c;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			String[] str = st.nextToken().split("");
			arr = new ArrayList<>();
			for(int i=0; i<n; i++) {
				arr.add((str[i].charAt(0)));
			}
			
			answer = "";
			solution();
			System.out.println("#" + test_case + " " + answer);
		}	
	}
}

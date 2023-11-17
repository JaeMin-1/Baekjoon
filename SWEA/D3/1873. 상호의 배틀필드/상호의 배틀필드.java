import java.io.*;
import java.util.*;

class Solution
{
	static int h, w;
	static char[][] arr;
	static char[] command;
	static int direction;
	public static void solution() {
		int x = 0;;
		int y = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(arr[i][j] == '^') {
					x = i;
					y = j;
					direction = 0;
				}
				if(arr[i][j] == 'v') {
					x = i;
					y = j;
					direction = 2;
				}
				if(arr[i][j] == '<') {
					x = i;
					y = j;
					direction = 3;
				}
				if(arr[i][j] == '>') {
					x = i;
					y = j;
					direction = 1;
				}
			}
		}
		
		for(char command : command) {
			if(command == 'U') {
				direction = 0;
				if(x-1>=0 && x-1<h && y>=0 && y<w && arr[x-1][y] == '.') {
					arr[x-1][y] = '^';
					arr[x][y] = '.';
					x = x-1;
				}
				else {
					arr[x][y] = '^';
				}
			}
			if(command == 'D') {
				direction = 2;
				if(x+1>=0 && x+1<h && y>=0 && y<w && arr[x+1][y] == '.') {
					arr[x+1][y] = 'v';
					arr[x][y] = '.'; 
					x = x+1;
				}
				else {
					arr[x][y] = 'v';
				}
			}
			if(command == 'L') {
				direction = 3;
				if(x>=0 && x<h && y-1>=0 && y-1<w && arr[x][y-1] == '.') {
					arr[x][y-1] = '<';
					arr[x][y] = '.';
					y= y-1;
				}
				else {
					arr[x][y] = '<';
				}
			}
			if(command == 'R') {
				direction = 1;
				if(x>=0 && x<h && y+1>=0 && y+1<w && arr[x][y+1] == '.') {
					arr[x][y+1] = '>';
					arr[x][y] = '.';
					y = y+1;
				}
				else {
					arr[x][y] = '>';
				}
			}
			if(command == 'S') {
				int i=0;
				if(direction == 0) {
					while(true) {
						if(x-1-i>=0 && x-1-i<h && y>=0 && y<w && arr[x-1-i][y] == '*') {
							arr[x-1-i][y] = '.';
							break;
						}
						if(x-1-i<0 || x-1-i>=h || arr[x-1-i][y] == '#') break;
						i++;
					}
				}
				if(direction == 1) {
					while(true) {
						if(x>=0 && x<h && y+1+i>=0 && y+1+i<w && arr[x][y+1+i] == '*') {
							arr[x][y+1+i] = '.';
							break;
						}
						if(y+1+i<0 || y+1+i>=w || arr[x][y+1+i] == '#') break;
						i++;
					}
				}
				if(direction == 2) {
					while(true) {
						if(x+1+i>=0 && x+1+i<h && y>=0 && y<w && arr[x+1+i][y] == '*') {
							arr[x+1+i][y] = '.';
							break;
						}
						if(x+1+i<0 || x+1+i>=h || arr[x+1+i][y] == '#') break;
						i++;
					}
				}
				if(direction == 3) {
					while(true) {
						if(x>=0 && x<h && y-1-i>=0 && y-1-i<w &&arr[x][y-1-i] == '*') {
							arr[x][y-1-i] = '.';
							break;
						}
						if(y-1-i<0 || y-1-i>=w || arr[x][y-1-i] == '#') break;
						i++;
					}
					
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			for(int i=0; i<h; i++) {
				String[] str = br.readLine().split("");
				for(int j=0; j<w; j++) {
					arr[i][j] = str[j].charAt(0); 
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			command = new char[n];
			for(int i=0; i<n; i++) {
				command[i] = str[i].charAt(0);
			}
			
			solution();
			
			System.out.print("#" + test_case + " ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}	
	}
}
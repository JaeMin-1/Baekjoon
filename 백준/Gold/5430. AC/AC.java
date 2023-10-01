import java.io.*;
import java.util.*;

public class Main {
    static String answer;
    static boolean isLeft;
    public static void solution(char[] func, ArrayList<String> num) {
        for(char c : func) {
            if(c == 'R') {
                if(isLeft) isLeft = false;
                else if(!isLeft) isLeft= true;
            }
            if(c == 'D') {
                if(num.size() == 0) answer = "error";
                else if(isLeft) num.remove(0);
                else if(!isLeft) num.remove(num.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            answer = "";
            isLeft = true;
            String p = br.readLine();
            char[] func = new char[p.length()];
            for(int i=0; i<p.length(); i++) {
                func[i] = p.charAt(i);
            }
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            ArrayList<String> num = new ArrayList<>();
            for(int i=0; i<n; i++) {
                num.add(st.nextToken());
            }
            solution(func, num);
            if (!answer.equals("error")) {
                StringBuilder result = new StringBuilder("[");
                if (num.size() != 0) {
                    if (isLeft) {
                        for (int i = 0; i < num.size() - 1; i++)
                            result.append(num.get(i)).append(",");
                        result.append(num.get(num.size() - 1));
                    }
                    else {
                        for (int i = num.size()-1; i > 0 ; i--)
                            result.append(num.get(i)).append(",");
                        result.append(num.get(0));
                    }
                }
                result.append("]");
                System.out.println(result.toString());
            } else {
                System.out.println(answer);
            }

        }
    }
}

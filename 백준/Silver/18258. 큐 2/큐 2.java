import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
                last = num;
            }
            else if(command.equals("pop")) {
                if (queue.isEmpty())
                    sb.append("-1").append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")) {
                if(queue.isEmpty())
                    sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(command.equals("front")) {
                if(queue.isEmpty())
                    sb.append("-1").append("\n");
                else sb.append(queue.peek()).append("\n");
            }
            else if(command.equals("back")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else sb.append(last).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String grade = sc.next();
        sc.close();
        
        double score = 0.0;
        if (grade.charAt(0) == 'A') {
            score += 4.0;
            if (grade.length() == 2) {
                if (grade.charAt(1) == '+') {
                    score += 0.3;
                } else if (grade.charAt(1) == '-') {
                    score -= 0.3;
                }
            }
        } else if (grade.charAt(0) == 'B') {
            score += 3.0;
            if (grade.length() == 2) {
                if (grade.charAt(1) == '+') {
                    score += 0.3;
                } else if (grade.charAt(1) == '-') {
                    score -= 0.3;
                }
            }
        } else if (grade.charAt(0) == 'C') {
            score += 2.0;
            if (grade.length() == 2) {
                if (grade.charAt(1) == '+') {
                    score += 0.3;
                } else if (grade.charAt(1) == '-') {
                    score -= 0.3;
                }
            }
        } else if (grade.charAt(0) == 'D') {
            score += 1.0;
            if (grade.length() == 2) {
                if (grade.charAt(1) == '+') {
                    score += 0.3;
                } else if (grade.charAt(1) == '-') {
                    score -= 0.3;
                }
            }
        }
        System.out.println(score);
    }
}

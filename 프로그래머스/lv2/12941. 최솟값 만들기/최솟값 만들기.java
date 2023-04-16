import java.util.*;
import java.io.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);  //A = 오름차순
        Arrays.sort(B);
        
        int[] B2 = new int[B.length];
        for(int i=0; i<B.length; i++) {
            B2[i] = B[B.length-i-1];  //B2 = 내림차순
        }
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B2[i];
        }

        return answer;
    }
}
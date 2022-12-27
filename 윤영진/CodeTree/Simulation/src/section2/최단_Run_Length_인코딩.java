package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최단_Run_Length_인코딩 {
    // 길이가 n인 문자열 A 
    // 특정 횟수만큼 오른쪽으로 shift하여, shift 된 이후의 문자열에 Run-Length-Encoding 을 진행했을 때의 길이가 최소

    // RLE 
    // 비손실 압축 방식으로, 연속해서 나온 문자와 연속해서 나온 개수로 나타내는 방식
    // aaabbbbcaa -> a3b4c1a2 

//    static char[] A;
    static String A;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        A = br.readLine().toCharArray();

        A = br.readLine();
        for (int i = 0; i < A.length(); i++) {
            A = shift();

            result = Math.min(result, RLE());
        }

        System.out.println(result);


    }

    private static int RLE() {

        char currChar = A.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < A.length(); i++) {
            if (currChar == A.charAt(i)) {
                count++;
            }else {
                sb.append(currChar).append(count);
                count = 1;
                currChar = A.charAt(i);
            }
        }
        sb.append(currChar).append(count);
        return sb.length();
    }

    private static String shift() {

//        char temp = A[A.length - 1];
//
//        for (int i = A.length - 1; i >= 1; i--) {
//            A[i] = A[i - 1];
//        }
//        A[0] = temp;
        return A.substring(1) + A.substring(0, 1);
    }
}

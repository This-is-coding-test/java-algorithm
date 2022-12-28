package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class 일차원_젠가_sol2 {

    // 2번에 걸쳐 특정 구간의 블럭들을 빼는 작업

    static int n;
    static int[] jenga;
    static int endOfArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        jenga = new int[n + 1];
        endOfArray = n;

        for (int i = 1; i <= n; i++) {
            jenga[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            simulate(start, end);
        }

        System.out.println(endOfArray);
        for (int i = 1; i <= endOfArray; i++) {
            System.out.println(jenga[i]);
        }


    }

    private static void simulate(int start, int end) {
        int cutLen = end - start + 1; // 4 - 2 + 1= 3
        for (int i = end + 1; i <= endOfArray; i++) { // 5 ~ 6
            jenga[i - cutLen] = jenga[i]; // jenga[5 - 3] = jenga[5]
        }

        endOfArray -= cutLen;
    }
}

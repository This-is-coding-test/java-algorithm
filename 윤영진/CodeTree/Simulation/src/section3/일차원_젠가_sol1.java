package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// int[][] arr = new int[6][6]
// int[][] temp = new int[6][6]

// int tempRow = n - 1;
// for(int row = n - 1; row >= 0; row--) {
//      if(arr[row][col] != 0) {
//            temp[tempRow][col] = arr[row][col];
//            tempRow--;
//      }

// int endOfArray = 6;
// int endOfTempArray = 0;
// int tempRow = n - 1;
// for(int i = 0; i < endOfArray; i++) {
//      if(arr[i] != 0) {
//          temp[endOfTempArray] = arr[i];
//      }

public class 일차원_젠가_sol1 {

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
        for (int i = 1; i <= n; i++) {
            if (jenga[i] != 0) {
                System.out.println(jenga[i]);
            }
        }


    }

    private static void simulate(int start, int end) {
        int endOfTempArray = 1;
        int[] temp = new int[n + 1];
        for (int i = 1; i <= endOfArray; i++) {
            if (i < start || i > end) {
                temp[endOfTempArray] = jenga[i];
                endOfTempArray++;
            }
        }

        for (int i = 1; i <= endOfArray; i++) {
            jenga[i] = temp[i];
        }

        endOfArray = endOfTempArray - 1;
    }
}

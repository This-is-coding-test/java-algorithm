package 피보나치_수열;

import java.util.Scanner;

public class Main {

    public int[] solution(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        /* 배열을 쓰지 않는 방법 */
//        int a = 1;
//        int b = 1;
//        int c;
//
//        System.out.print(a + " ");
//        System.out.print(b + " ");
//
//        for (int i = 2; i < n; i++) {
//            c = a + b;
//            System.out.print(c + " ");
//
//            a = b;
//            b = c;
//        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Main main = new Main();
        int[] result = main.solution(n);

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }

}

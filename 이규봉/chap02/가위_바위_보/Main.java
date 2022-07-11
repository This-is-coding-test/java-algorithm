package 가위_바위_보;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public List<String> solution(int[] a, int[] b) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] + 1 == b[i] || b[i] + 2 == a[i]) {
                result.add("B");
            } else if (a[i] == b[i]) {
                result.add("D");
            } else {
                result.add("A");
            }
        }

        /* 가위, 바위, 보 경우를 각각 계산 */
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == b[i]) {
//                result.add("D");
//            } else if (a[i] == 1 && b[i] == 3) {
//                result.add("A");
//            } else if (a[i] == 2 && b[i] == 1) {
//                result.add("A");
//            } else if (a[i] == 3 && b[i] == 2) {
//                result.add("A");
//            } else {
//                result.add("B");
//            }
//        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<String> result = main.solution(a, b);
        result.forEach(System.out::println);
    }

}

package 점수_계산;

import java.util.Scanner;

public class Main {

    public int solution(int[] data) {
//        int result = 0;
//
//        for (int i = 1; i < data.length; i++) {
//            if (data[i] == 1) {
//                data[i] = data[i - 1] + 1;
//            }
//        }
//
//        for (int datum : data) {
//            result += datum;
//        }

        int result = 0;
        int count = 0;

        for (int datum : data) {
            if (datum == 1) {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data  = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Main main = new Main();
        int result = main.solution(data);
        System.out.println(result);
    }

}

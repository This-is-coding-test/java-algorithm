package 버블_정렬;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {
        // 맨 뒤 원소를 제일 큰 수로
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        int[] answer = main.solution(n, arr);
        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
    }

}

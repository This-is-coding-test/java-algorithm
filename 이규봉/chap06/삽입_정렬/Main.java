package 삽입_정렬;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 뒤로 미루기
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // break 될 때의 j는 arr[i] 보다 작기 때문에 그 뒤에 바로 삽입
            arr[j + 1] = tmp;
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
        for (int e : answer) {
            System.out.print(e + " ");
        }
    }

}

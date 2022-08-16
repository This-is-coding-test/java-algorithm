package 선택_정렬;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {
        // arr[i] 를 i 번째 이후 원소들 중 최소값으로 설정
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    idx = j;
                }
            }
            // swap
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
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

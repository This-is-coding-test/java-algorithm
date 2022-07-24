package 최대_매출;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int sum = 0;

        // 첫 k개 합으로 초기화
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // 슬라이딩 윈도우
        // 다음 인덱스 값을 더하고 맨 앞의 인덱스 값은 빼주기
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        int answer = main.solution(n, k, arr);
        System.out.println(answer);
    }

}

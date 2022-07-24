package 연속_부분수열;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {
        int count = 0;
        int sum = 0;
        int left = 0;

        // right 누적해서 더 해주기
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            if (sum == m) {
                count++;
            }
            // 작아질 때까지 left 증가시켜주기
            while (sum >= m) {
                sum -= arr[left++];
                if (sum == m) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        int answer = main.solution(n, m, arr);
        System.out.println(answer);
    }

}

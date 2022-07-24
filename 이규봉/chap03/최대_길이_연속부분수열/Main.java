package 최대_길이_연속부분수열;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int max = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }

            // 길이 구하기 -> rt - lt + 1
            max = Math.max(max, rt - lt + 1);
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

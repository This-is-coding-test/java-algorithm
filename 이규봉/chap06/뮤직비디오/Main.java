package 뮤직비디오;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;

        for (int x : arr) {
            // 용량 초과 시
            if (sum + x > capacity) {
                cnt++;
                // sum 초기화
                sum = x;
            } else {
                // 용량이 찰 때까지 누적
                sum += x;
            }
        }

        return cnt;
    }

    public int solution(int m, int[] arr) {
        int answer = 0;
        // max()의 반환 값은 Optional
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
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
        int answer = main.solution(m, arr);
        System.out.println(answer);
    }

}

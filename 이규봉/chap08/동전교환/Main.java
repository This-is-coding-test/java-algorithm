package 동전교환;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                // 함수가 리턴되면 다음 i로 넘어감 (다음 동전으로)
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        m = scanner.nextInt();

        Main main = new Main();
        // 내림차순으로 정렬해서 더 빠르게
        Arrays.sort(arr, Collections.reverseOrder());
        main.DFS(0, 0, arr);
        System.out.println(answer);
    }

}

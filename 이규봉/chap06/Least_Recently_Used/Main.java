package Least_Recently_Used;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];

        for (int i = 0; i < n; i++) {
            // 캐시 히트 여부를 위한 플래그
            boolean contains = false;

            for (int j = 0; j < s; j++) {
                // 캐시 히트
                if (cache[j] == arr[i]) {
                    int idx = j - 1;

                    // 한 칸씩 뒤로 이동
                    while (idx >= 0) {
                        cache[idx + 1] = cache[idx];
                        idx--;
                    }

                    contains = true;
                }
            }

            // 캐시 미스
            if (!contains) {
                // 한 칸씩 뒤로 이동
                for (int j = s - 1; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            }

            // 맨 앞에 삽입
            cache[0] = arr[i];
        }

        return cache;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        int[] answer = main.solution(s, n, arr);
        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
    }

}

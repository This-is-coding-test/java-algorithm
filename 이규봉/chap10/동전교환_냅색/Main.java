package 동전교환_냅색;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int solution(int n, int[] arr, int m) {
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        Main main = new Main();
        int answer = main.solution(n, arr, m);
        System.out.println(answer);
    }

}

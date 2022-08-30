package 순열_구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr, answer;
    static boolean[] visit;

    public void DFS(int L) {
        if (L == m) {
            Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    answer[L] = arr[i];
                    DFS(L + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        answer = new int[m];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        main.DFS(0);

    }

}

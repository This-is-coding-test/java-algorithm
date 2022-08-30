package 합이_같은_부분집합;

import java.util.Scanner;

public class Main {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            // L 번째 원소를 사용하겠다.
            DFS(L + 1, sum + arr[L], arr);
            // L 번째 원소를 사용하지 않겠다.
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }

        Main main = new Main();
        main.DFS(0, 0, arr);
        System.out.println(answer);
    }

}

package 바둑이_승차;

import java.util.Scanner;

public class Main {
    static int answer = Integer.MIN_VALUE, c, n;

    public void DFS(int L, int sum, int[] arr) {
        // c 를 넘어가면 끝난 것이니 바로 리턴
        if (sum > c) return;
        if (L == n) {
            // 처음엔 리스트에 add 해서 max 로 풀었음
            // static 변수로 answer 를 선언해놓고 Math.max 로 풀면 굳이 리스트 만들 필요 x
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        main.DFS(0, 0, arr);
        System.out.println(answer);
    }

}

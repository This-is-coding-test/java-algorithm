package 조합_구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] combi;

    // 조합 구현 외우기
    public void DFS(int L, int s) {
        if (L == m) {
            Arrays.stream(combi).forEach(e -> System.out.print(e + " "));
            System.out.println();
        } else {
            // 조합이므로 s 부터 n 까지
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                // start 를 다음 번호로 부여
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        combi = new int[m];

        Main main = new Main();
        main.DFS(0, 1);

    }

}

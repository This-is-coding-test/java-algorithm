package 중복순열_구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] pm;
    static int n, m;

    public void DFS(int L) {
        if (L == m) {
            Arrays.stream(pm).forEach(e -> System.out.print(e + " "));
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];

        Main main = new Main();
        main.DFS(0);

    }

}

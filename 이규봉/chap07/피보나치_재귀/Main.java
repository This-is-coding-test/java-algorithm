package 피보나치_재귀;

public class Main {

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            /* ex. DFS(5) */
            // DFS(3) + DFS(4)
            // { DFS(1) + DFS(2) } + { DFS(2) + DFS(3) }
            // 1 + 1 + 1 + DFS(1) + DFS(2)
            // 1 + 1 + 1 + 1 + 1
            return DFS(n - 2) + DFS(n - 1);
        }
    }

    /* 메모제이션 이용 */
    static int[] fibo;
    public int DfsMemoization(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int n = 45;
        fibo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
//            System.out.print(main.DFS(i) + " ");
            System.out.print(main.DfsMemoization(i) + " ");
        }
    }

}

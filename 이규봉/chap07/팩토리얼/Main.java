package 팩토리얼;

public class Main {

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            // 5 * DFS(4)
            // 5 * 4 * DFS(3)
            // 5 * 4 * 3 * DFS(2)
            // 5 * 4 * 3 * 2 * DFS(1)
            // 5 * 4 * 3 * 2 * 1
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.DFS(5));
    }

}

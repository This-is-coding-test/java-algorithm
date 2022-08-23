package 이진수_출력;

public class Main {

    /* 나머지를 이용하여 십진수를 이진수로 변환 */
    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.DFS(11);
    }

}

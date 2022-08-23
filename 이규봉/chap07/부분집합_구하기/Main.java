package 부분집합_구하기;

public class Main {

    static int n;
    static  int[] ch;

    public void DFS(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sb.append(i).append(" ");
            }
            if (sb.length() > 0) System.out.println(sb);
        } else {
            ch[L] = 1;
            DFS(L + 1); // 왼쪽으로 뻗는다
            ch[L] = 0;
            DFS(L + 1); // 오른쪽으로 뻗는다
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];

        Main main = new Main();
        main.DFS(1);
    }

}

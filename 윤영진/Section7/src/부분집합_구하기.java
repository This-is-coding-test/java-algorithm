import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합_구하기 {

    public static boolean[] check;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N + 1];
        DFS(1);

    }
    // 그림 그려보기
    // DFS(1) == 원소 1이 존재한다, 존재하지 않는다.
    private static void DFS(int n) {

        if (n == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (check[i]) {
                    sb.append(i).append(" ");
                }
            }
            if (sb.length() != 0) {
                System.out.println(sb);
            }
        }else {
            check[n] = true;
            DFS(n + 1);
            check[n] = false;
            DFS(n + 1);
        }

    }



}

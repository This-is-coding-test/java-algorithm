import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀번호 {
    // 가운데 있는 친구를 기준으로 왼쪽과 오른쪽에 있던 친구들이 두 손을 마주잡고 춤을 춘다.
    static int n, m;
    static boolean[] visited = new boolean[10];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                visited[num] = true;
            }
        }

        backtracking(0, 0);
        System.out.println(answer);

    }

    private static void backtracking(int depth, int cnt) {
        if (depth == n) {
            if (cnt == m) answer++;
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i]) {
                    visited[i] = false;
                    backtracking(depth + 1, cnt + 1);
                    visited[i] = true;
                } else {
                    backtracking(depth + 1, cnt);
                }
            }

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사다리_조작 {
    static class Line {
        int a; // a 가로선
        int b; // b, b + 1 세로선

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int N, M, H;
    static boolean[][] visited;
    static ArrayList<Line> lines = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H + 1][N + 1]; // (6, 4)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Line(a, b));
            visited[a][b] = true;
        }

        int answer = 0;
        for (int i = 0; i <= 3; i++) {
            answer = i;
            backtracking(0, i, 1);
            if (flag) break;
        }

        System.out.println(flag ? answer : -1);

    }

    private static void backtracking(int depth, int cnt, int x) {
        if (flag) return;
        if (cnt == depth) {
            if (isPossible()) flag = true;
        } else {
            // (1, 1) ~ (6 4)
            for (int i = x; i <= H; i++) { // 3
                for (int j = 1; j < N; j++) { // 4
                    if (!visited[i][j] && !visited[i][j - 1] && !visited[i][j + 1]) {
                        visited[i][j] = true;
                        lines.add(new Line(i, j));
                        backtracking(depth + 1, cnt, i);
                        lines.remove(lines.size() - 1);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean isPossible() {
        ArrayList<Line> tmpList = (ArrayList<Line>) lines.clone();
        tmpList.sort((o1, o2) -> {
            if (o1.a == o2.a) return o1.b - o2.b;
            return o1.a - o2.a;
        });
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (Line line : tmpList) { // (1 1)
            int tmp = arr[line.b]; // 1
            arr[line.b] = arr[line.b + 1];
            arr[line.b + 1] = tmp;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] != i) return false;
        }
        return true;
    }
}

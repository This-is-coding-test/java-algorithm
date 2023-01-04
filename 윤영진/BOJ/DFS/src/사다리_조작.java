import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 사다리_조작 {

    static class Pair {
        int idx;
        int stair;

        public Pair(int idx, int stair) {
            this.idx = idx;
            this.stair = stair;
        }

    }

    static int N, M, H;
    static List<Pair> selectedLines = new ArrayList<>();
    static int count = Integer.MAX_VALUE;
    static boolean[][] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        if (M == 0) {
            System.out.println(0);
            return;
        }

        visited = new boolean[H + 1][N]; // [6][5]

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int stair = Integer.parseInt(st.nextToken()); // 1
            int idx = Integer.parseInt(st.nextToken()); // 1

            visited[stair][idx] = true;
            selectedLines.add(new Pair(idx, stair));
        }

        for (int i = 0; i <= 3; i++) {
            if (!flag) {
                findMinLines(0, i);
            }
        }
        System.out.println(flag ? count : "-1");
    }

    private static void findMinLines(int depth, int cnt) {
        if (flag) return;
        if (depth == cnt) {
            if (check() && isPossible()) {
                count = Math.min(count, selectedLines.size() - M);
                flag = true;
            }
        } else {

            for (int i = 1; i <= H; i++) { // stair
                for (int j = 1; j < N; j++) { // idx
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        selectedLines.add(new Pair(j, i));
                        findMinLines(depth + 1, cnt);

                        selectedLines.remove(selectedLines.size() - 1);
                        visited[i][j] = false;
                    }

                }
            }

        }

    }

    private static boolean isPossible() {

        List<Pair> copyLine = new ArrayList<>();
        for (int i = 0; i < selectedLines.size(); i++) {
            copyLine.add(selectedLines.get(i));
        }

        Collections.sort(copyLine, (o1, o2) -> {
            if (o1.stair != o2.stair) return o1.stair - o2.stair;
            return o1.idx - o2.idx;
        });

        int[] num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = i;
        }

        for (int i = 0; i < copyLine.size(); i++) {
            int idx = copyLine.get(i).idx;
            int temp = num[idx];
            num[idx] = num[idx + 1];
            num[idx + 1] = temp;
        }

        for (int i = 1; i <= N; i++) {
            if (num[i] != i) return false;
        }

        return true;
    }

    private static boolean check() {


        for (int i = 0; i < selectedLines.size(); i++) {
            for (int j = i + 1; j < selectedLines.size(); j++) {
                if (selectedLines.get(i).stair == selectedLines.get(j).stair) {
                    if (selectedLines.get(i).idx == selectedLines.get(j).idx - 1
                            || selectedLines.get(i).idx == selectedLines.get(j).idx +1) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}

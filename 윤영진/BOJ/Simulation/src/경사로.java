import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {
    // N * N 지도
    // 지나갈 수 있는 길이 몇 개인지 ?
    // 길이란 한 행 또는 한 열 전부를 나타내며, 한쪽 끝에서 다른쪽 끝가지 지나가는 것

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        // 행, 열 확인
        for (int i = 0; i < N; i++) {
            if (simulate1(i)) cnt++;
            if (simulate2(i)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean simulate1(int row) {
        boolean[] visited = new boolean[N];


        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if (Math.abs(diff) > 1) return false;
            else if (diff == -1) { // 아래 -> 위
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || visited[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    visited[i - j] = true;
                }
            } else if (diff == 1) { // 위 -> 아래
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || visited[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean simulate2(int col) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];
            if (Math.abs(diff) > 1) return false;
            else if (diff == -1) { // 아래 -> 위
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || visited[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    visited[i - j] = true;
                }
            } else if (diff == 1) { // 위 -> 아래
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || visited[i + j]) return false;
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }


}

package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양수_직사각형의_최대_크기_sol1 {
    static int n, m;
    static int[][] map;
    static int result = -1;

    // 1. 양쪽 꼭지점으로 직사각형 선택
    // 2. 전부 양수인지 체크
    // 3. 전부 양수인 경우 크기 갱신

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findRect();
        System.out.println(result);
    }

    // 1. 양쪽 꼭지점으로 직사각형 선택
    private static void findRect() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        // 2. 전부 양수인지 체크
                        if (isPositive(i, j, k, l)) {
                            result = Math.max(result, (k - i + 1) * (l - j + 1));
                        }
                    }
                }
            }
        }

    }

    private static boolean isPositive(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] <= 0) return false;
            }
        }
        return true;
    }
}

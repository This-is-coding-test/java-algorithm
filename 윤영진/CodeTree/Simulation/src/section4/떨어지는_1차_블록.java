package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떨어지는_1차_블록 {
    static int n, m, k;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void simulate() {

        // 1행부터 확인
        int row;
        boolean flag = false;
        for (row = 1; row <= n; row++) { // 1행부터
            for (int j = k; j < k + m; j++) { // k열부터 k + m 열까지
                if (map[row][j] != 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        for (int j = k; j < k + m; j++) {
            map[row - 1][j] = 1;
        }
    }
}

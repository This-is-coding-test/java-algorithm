package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양수_직사각형의_최대_크기_sol2 {
    static int n, m;
    static int[][] map;
    static int result = -1;

    // down-max[i][j] = (i, j)을 시작으로 밑으로 쭉 내려가며 만들 수 있는 가로가 1인 직사각형 중 최대 직사각형의 크기

    // 1. 양쪽 꼭지점으로 직사각형 선택
    // 2. 전부 양수인지 체크
    // 3. 전부 양수인 경우 크기 갱신

    public static final int MAX_NUM = 20;
    public static int[][] downMax = new int[MAX_NUM][MAX_NUM];

    public static void preProcessing() {
        // 마지막 행에 대해 계산합니다.
        for (int j = 0; j < m; j++)
            if (map[n - 1][j] > 0)
                downMax[n - 1][j] = 1;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                // (i, j)에 적혀있는 수가 양수라면
                // 이전 최대 직사각형의 크기에 1을 더한 만큼 가능합니다.
                if (map[i][j] > 0)
                    downMax[i][j] = downMax[i + 1][j] + 1;
            }
        }
    }

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
        preProcessing();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] <= 0) continue;

                int bestHeight = Integer.MAX_VALUE;
                for (int l = j; l < m; l++) {
                    bestHeight = Math.min(bestHeight, downMax[i][l]); // 0
                    System.out.println(bestHeight);

                    int k = i + bestHeight - 1;
                    result = Math.max(result, (k - i + 1) * (l - j + 1));

                }
            }
        }

        System.out.println(result);
    }


}

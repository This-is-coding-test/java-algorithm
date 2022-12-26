import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금_채굴하기_sol3 {

    // n * n 크기의 이차원 영역에 파묻힌 금을 손해를 보지 않는 선에서 최대한 많이 채굴
    // 채굴을 마름모 모양으로 단 한 번
    // 마름모 모양을 지키는 한 이차원 영역을 벗어난 채굴도 가능

    // 채굴에 드는 비용은 마름모 안의 격자 갯수 -> K * K + (K+1) * (K+1)
    // 금 한 개의 가격이 m일 때, 손해를 보지 않으면서 채굴할 수 있는 가장 많은 금의 개수를 출력

    // 마름모 내부만 탐색
    static int n, m;
    static int[][] map;
    static int result = 0;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};

    public static int getNumOfGold(int row, int col, int k) {
        int numOfGold = 0;
        if (k == 0) return map[row][col];

        int curX = row - k;
        int curY = col;

        for (int dir = 0; dir < 4; dir++) {
            for (int step = 0; step < k; step++) {
                if (curX < n && curY < n && curX >= 0 && curY >= 0) {
                    numOfGold += map[curX][curY];
                }
                curX += dx[dir];
                curY += dy[dir];
            }
        }


        return numOfGold;
    }

    private static int getArea(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 격자를 순회하며, 각 위치가 마름모의 중심일 때 K를 0부터 가능한 범위까지 늘려가며 확인

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int numOfGold = 0;
                for (int k = 0; k <= 2 * (n - 1); k++) {
                    numOfGold += getNumOfGold(i, j, k);

                    // 손해?
                    if (numOfGold * m >= getArea(k)) {
                        result = Math.max(result, numOfGold);
                    }
                }
            }
        }

        System.out.println(result);
    }


}
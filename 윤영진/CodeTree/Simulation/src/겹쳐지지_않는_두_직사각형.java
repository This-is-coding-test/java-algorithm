import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹쳐지지_않는_두_직사각형 {

    static int n, m;
    static int[][] map;
    static int[][] board;
    static int result = Integer.MIN_VALUE;

    // 영역 안에서 서로 겹치지 않는 두 직사각형을 적절하게 잡아, 두 직사각형 안에 적힌 숫자들의 총 합을 최대로 하는 프로그램
    // 꼭 2개의 직사각형, 경꼐는 서로 닿아도 된다.

    // 1. 양쪽 꼭지점으로 하는 첫 번째 직사각형을 정한다.

    // 2. 두 번째 직사각형을 정한다.

    // 3. 겹치는지 확인한다. -> clearBoard, drawBoardRect1, drawBoardRect2, checkBoard

    // 4. 겹치지 않았으면 최대 합을 반환한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMaxSum();
        System.out.println(result);


    }

    // 1. 양쪽 꼭지점으로 하는 첫 번째 직사각형을 정한다.
    private static void findMaxSum() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        result = Math.max(result, findMaxSum(i, j, k, l));
                    }
                }
            }
        }
    }

    // 2. 두 번째 직사각형을 정한다.
    private static int findMaxSum(int x1, int y1, int x2, int y2) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {

                        // 3. 겹치는지 확인한다.
                        if (!isOverlapped(x1, y1, x2, y2, i, j, k, l)) {
                            // 4. 겹치지 않았으면 최대 합을 반환한다.
                            maxSum = Math.max(maxSum, rectSum(x1, y1, x2, y2) + rectSum(i, j, k, l));
                        }
                    }
                }
            }
        }

        return maxSum;

    }

    private static int rectSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static boolean isOverlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        clearBoard();
        drawBoard(x1, y1, x2, y2);
        drawBoard(x3, y3, x4, y4);
        return checkBoard();
    }

    private static boolean checkBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= 2) return true;
            }
        }
        return false;
    }

    private static void drawBoard(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                board[i][j] += 1;
            }
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = 0;
            }
        }
    }

}

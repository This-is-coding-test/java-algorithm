import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행복한_수열의_개수 {

    // 1이상 100이하의 숫자로만 이루어져 있는 n*n 크기의 격자
    // 행복한 수열 = 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열

    static int n, m;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m == 1) {
            System.out.println(n * 2);
            return;
        }
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 행, 열
        calculate();
        System.out.println(result);
    }

    private static void calculate() {

        for (int i = 0; i < n; i++) { // 행, 열
            checkRow(i);
            checkCol(i);
        }


    }

    private static void checkCol(int i) {
        int countCol = 1;
        for (int j = 0; j < n - 1; j++) {
            if (map[j][i] == map[j + 1][i]) {
                countCol++;
                if (countCol == m) {
                    result++;
                    break;
                }
            } else {
                countCol = 1;
            }
        }
    }

    private static void checkRow(int i) {
        int countRow = 1;
        for (int j = 0; j < n - 1; j++) {
            if (map[i][j] == map[i][j + 1]) {
                countRow++;
                if (countRow == m) {
                    result++;
                    break;
                }
            } else {
                countRow = 1;
            }
        }
    }
}

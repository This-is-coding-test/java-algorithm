import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class 트로미노 {

    // n*m 크기의 이차원 영역의 각 위치에 자연수가 하나씩 적혀있다.
    // 이 때 아래의 그림에 주어진 2가지 종류의 블럭 중 한 개를 블럭이 격자를 벗어나지 않도록 적당히 올려놓아 블럭이 놓인 칸 안에 적힌 숫자의 합이 최대가 될 때의 결과를 출력

    static int n, m;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    

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

        // block 1번 체크
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                result = Math.max(result, check1(i, j));
            }
        }

        // block 2번 체크 - 행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                // 행
                result = Math.max(result, checkRow(i, j)); // 행 고정
            }
        }

        // block 2번 체크 - 열

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m; j++) {
                // 열
                result = Math.max(result, checkCol(i, j)); // 열 고정
            }
        }

        System.out.println(result);
    }

    private static int checkCol(int i, int j) {
        int sum = 0;

        for (int k = i; k <= i + 2; k++) {
            sum += map[k][j];
        }

        return sum;

    }

    private static int checkRow(int i, int j) {
        int sum = 0;

        for (int k = j; k <= j + 2; k++) { // k -> 0, 1, 2
            sum += map[i][k];
        }
        return sum;
    }

    private static int check1(int i, int j) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int k = i; k < i + 2; k++) {
            for (int l = j; l < j + 2; l++) {
                sum += map[k][l];
            }
        }

        for (int k = i; k < i + 2; k++) {
            for (int l = j; l < j + 2; l++) {
                sum -= map[k][l];
                maxSum = Math.max(maxSum, sum);
                sum += map[k][l];
            }
        }

        return maxSum;

    }
}

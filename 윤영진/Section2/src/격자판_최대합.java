import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자판_최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 계산
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
            if (sum > result) result = sum;
        }

        // 열 계산
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[j][i];
            }
            if (sum > result) result = sum;
        }

        // 대각선 계산
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) sum1 += arr[i][j];
                if ((i + j) == N - 1) sum2 += arr[i][j];
            }
        }

        if (sum1 > result) result = sum1;
        if (sum2 > result) result = sum2;

        System.out.println(result);


    }
}

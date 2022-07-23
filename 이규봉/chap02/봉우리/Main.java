package 봉우리;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int result = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                boolean isHighest = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (arr[i][j] <= arr[nx][ny]) {
                        isHighest = false;
                        break;
                    }
                }
                if (isHighest) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        int result = main.solution(n, arr);
        System.out.println(result);
    }

}

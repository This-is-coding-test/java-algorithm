package 임시반장_정하기;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {
        int result = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 5; k++) {
                    // i번 학생의 k학년 반이 j번 학생의 k학년 반과 같다면
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        // j번 학생과 같은 반이 된 적이 있는지 한 번만 계산
                        break;
                    }
                }

            }
            if (count > max) {
                max = count;
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 0번 인덱스 무시하고 1부터 사용할 예정(1번 인덱스 - 1학년)
        int[][] arr = new int[n + 1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        int result = main.solution(n, arr);
        System.out.println(result);
    }

}

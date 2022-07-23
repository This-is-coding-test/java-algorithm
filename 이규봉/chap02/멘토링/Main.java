package 멘토링;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        // i번 학생과 j번 학생의 k 시험에서 등수가 앞서야 함
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;
                    // k 시험에서 i번 학생과 j번 학생의 등수를 구하기 위한 for문
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) {
                            pi = l;
                        } else if (arr[k][l] == j) {
                            pj = l;
                        }
                    }
                    // 등수가 앞선다면
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == m) {
                    answer++;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        int answer = main.solution(n, m, arr);
        System.out.println(answer);
    }

}

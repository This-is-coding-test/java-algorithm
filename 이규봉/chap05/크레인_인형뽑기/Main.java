package 크레인_인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            // 인덱스 0 부터 시작이므로 맞춰주기
            int col = moves[i] - 1;
            int pick;
            for (int j = 0; j < n; j++) {
                // 0 이 아닐 때 까지 내려가기
                if (board[j][col] != 0) {
                    pick = board[j][col];
                    // 뽑았으면 0으로 바꿔주기
                    board[j][col] = 0;
                    // 연속된 것을 뽑았다면 삭제
                    if (!stack.empty() && stack.peek() == pick) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(pick);
                    }
                    // 뽑았으면 break 해주기
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }

        Main main = new Main();
        int answer = main.solution(n, board, m, moves);
        System.out.println(answer);
    }

}

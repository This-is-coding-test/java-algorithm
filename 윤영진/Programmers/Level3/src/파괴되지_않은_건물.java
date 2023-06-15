public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1]; // 누적합

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            if (type == 1) degree = -degree;

            diff[r1][c1] += degree;
            diff[r1][c2 + 1] += -degree;
            diff[r2 + 1][c1] += -degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < m; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }

        for (int c = 0; c < m; c++) {
            for (int r = 1; r < n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}

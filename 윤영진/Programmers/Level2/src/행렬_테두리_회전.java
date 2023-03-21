import java.util.*;

class 행렬_테두리_회전 {
    // (x1, y1, x2, y2) : (x1, y1) 부터 (x2, y2) 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전
    // 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
    static int[][] map;
    static int r, c;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        r = rows;
        c = columns;
        map = initMap();
        int idx = 0;
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            answer[idx++] = rotate(x1 - 1, y1 - 1, x2 - 1, y2 - 1);

        }
        return answer;
    }

    public int[][] initMap() {
        int[][] map = new int[r][c];
        int num = 1;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                map[i][j] = num++;
            }
        }
        return map;
    }

    public int rotate(int x1, int y1, int x2, int y2) { // 2, 2, 5, 4
        int min = Integer.MAX_VALUE;

        int tmp = map[x1][y1];
        min = Math.min(min, tmp);

        // Step2
        for (int i = x1; i <= x2 - 1; i++) { // 2 ~ 4
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        // Step3
        for (int i = y1; i <= y2 - 1; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }

        // Step4
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);

        }

        // Step5
        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }

        // Step6
        map[x1][y1 + 1] = tmp;

        return min;
    }
}

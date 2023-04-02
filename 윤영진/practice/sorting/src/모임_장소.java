import java.util.*;

class 모임_장소 {
    static List<Integer> rows = new ArrayList<>();
    static List<Integer> cols = new ArrayList<>();

    public int solution(int[][] board) {
        int n = board.length;
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        Collections.sort(cols);
        int rowIdx = rows.get(rows.size() / 2);
        int colIdx = cols.get(cols.size() / 2);

        return getDist(rowIdx, colIdx);
    }

    private Integer getDist(int x, int y) {
        int dist = 0;
        for (int i = 0; i < rows.size(); i++) {
            dist += Math.abs(rows.get(i) - x);
            dist += Math.abs(cols.get(i) - y);
        }
        return dist;
    }

    public static void main(String[] args) {
        모임_장소 T = new 모임_장소();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}

import java.util.*;

class 바둑대회 {
    static int n;
    static int[][] Cans;
    static boolean[] visited;
    static int answer;

    public int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        n = cans.length;
        visited = new boolean[n];
        Cans = cans;

        dfs(0, 0);


        return answer;
    }

    private void dfs(int depth, int start) {
        if (depth == n / 2) {
            answer = Math.min(answer, calc());
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private int calc() {

        int sumW = 0;
        int sumB = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sumW += Cans[i][0];
            } else sumB += Cans[i][1];
        }

        return Math.abs(sumW - sumB);
    }

    public static void main(String[] args) {
        바둑대회 T = new 바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}

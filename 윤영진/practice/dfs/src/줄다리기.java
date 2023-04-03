
import java.util.*;

class 줄다리기 {
    // 서로 싫어하는 학생끼리 이웃하지 않게 줄을 세우는 경우의 수
    // 전체 경우의 수 - 이웃하게 세우는 경우

    boolean[][] relation;
    boolean[] visited;
    int answer = 0;

    public int solution(int[][] fight) {
        answer = 0;
        visited = new boolean[8];
        relation = new boolean[8][8];

        for (int i = 0; i < fight.length; i++) {
            relation[fight[i][0]][fight[i][1]] = true;
            relation[fight[i][1]][fight[i][0]] = true;
        }

        dfs(0, -1);

        return answer;
    }

    private void dfs(int depth, int prev) {
        if (depth == 7) {
            answer++;
        } else {
            for(int i = 1; i <= 7; i++) {
                if(prev == -1) {
                    visited[i] = true;
                    dfs(depth + 1, i);
                    visited[i] = false;
                }
                else if(!visited[i] && !relation[prev][i]) {
                    visited[i] = true;
                    dfs(depth + 1, i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        줄다리기 T = new 줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

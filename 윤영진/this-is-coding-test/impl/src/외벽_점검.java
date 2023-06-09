public class 외벽_점검 {
    int[][] weakCase;
    int[] distCase;
    boolean[] visited;
    int size;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        weakCase = new int[weak.length][weak.length];
        distCase = new int[dist.length];
        visited = new boolean[dist.length];

        makeWeakCase(weak, n);
        perm(0, dist);
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    public void perm(int depth, int[] dist) {
        if (depth == dist.length) {
            check();
        } else {
            for (int i = 0; i < dist.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    distCase[depth] = dist[i];
                    perm(depth + 1, dist);
                    visited[i] = false;
                }
            }

        }
    }

    public void makeWeakCase(int[] weak, int n) {
        weakCase[0] = weak.clone();

        for (int i = 1; i < weak.length; i++) {
            int temp = weakCase[i - 1][0];
            for (int j = 0; j < weak.length - 1; j++) {
                weakCase[i][j] = weakCase[i - 1][j + 1];
            }
            weakCase[i][weak.length - 1] = temp + n;
        }
    }

    public void check() {

        for (int i = 0; i < weakCase.length; i++) {

            int idx = 0; // distIdx
            int cur = 0; // weakIdx
            int next;

            while (cur < weakCase[i].length && idx < distCase.length) {
                next = cur + 1;

                while (next < weakCase[i].length &&
                        weakCase[i][next] - weakCase[i][cur] <= distCase[idx]) {
                    next++;
                }

                cur = next;
                idx++;
            }
            if (cur == weakCase[i].length) {
                answer = Math.min(answer, idx);
            }

        }


    }
}
public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];

            adj[A][B] = 1;
        }

        for (int middle = 1; middle <= n; middle++) {

            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (adj[start][middle] == 1 && adj[middle][end] == 1) {
                        adj[start][end] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 1 || adj[j][i] == 1) count++;
            }
            if (count == n - 1) answer++;
        }
        return answer;
    }
}

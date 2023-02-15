import java.io.*;
import java.util.*;

public class 링크와_스타트 {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);

    }

    private static void dfs(int depth) {
        if (depth == N) {
            result = Math.min(result, calculate());
        } else {
            visited[depth] = true;
            dfs(depth + 1);
            visited[depth] = false;
            dfs(depth + 1);
        }
    }

    private static int calculate() {
        List<Integer> link = new ArrayList<>();
        List<Integer> start = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                link.add(i);
            } else {
                start.add(i);
            }
        }

        if (link.size() == 0 || start.size() == 0) return Integer.MAX_VALUE;

        int linkSum = 0;
        int startSum = 0;

        for (int i = 0; i < link.size(); i++) {
            for (int j = i + 1; j < link.size(); j++) {
                linkSum += arr[link.get(i)][link.get(j)] + arr[link.get(j)][link.get(i)];
            }
        }

        for (int i = 0; i < start.size(); i++) {
            for (int j = i + 1; j < start.size(); j++) {
                startSum += arr[start.get(i)][start.get(j)] + arr[start.get(j)][start.get(i)];
            }
        }
        return Math.abs(linkSum - startSum);


    }

}
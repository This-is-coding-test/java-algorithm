import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 링크와_스타트 {

    static int N;
    static int[][] arr;

    static List<Integer> link = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
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
            if (link.size() == N || link.size() == 0) return;
            List<Integer> start = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!link.contains(i)) start.add(i);
            }
            result = Math.min(result, calculate(start));
        } else {
            link.add(depth);
            dfs(depth + 1);
            link.remove(link.size() - 1);
            dfs(depth + 1);
        }
    }

    private static int calculate(List<Integer> start) {
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
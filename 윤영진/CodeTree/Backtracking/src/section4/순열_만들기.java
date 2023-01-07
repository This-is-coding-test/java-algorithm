package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 순열_만들기 {
    static int n;
    static List<Integer> output = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            for (Integer val : output) {
                sb.append(val + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] =true;
                    output.add(i);
                    backtracking(depth + 1);
                    visited[i] = false;
                    output.remove(output.size() - 1);
                }
            }


        }
    }
}

import java.util.*;
import java.io.*;

public class N과M_1 {

    static int N, M;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        output = new int[N];
        visited = new boolean[N + 1];

        backtracking(0);
        System.out.println(sb);

    }

    private static void backtracking(int depth) {
        if (depth == M) {

            for(int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<= N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }


    }
}
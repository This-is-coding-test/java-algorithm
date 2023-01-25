import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자고르기 {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int curr;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int v = Integer.parseInt(br.readLine());
            arr[i] = v;
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            curr = i;
            dfs(i);
            visited[i] = false;
        }

        result.sort(Comparator.comparingInt(o -> o));
        System.out.println(result.size());
        for (Integer v : result) {
            System.out.println(v);
        }
    }

    private static void dfs(int i) {
        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
        if (curr == arr[i]) {
            result.add(curr);
        }

    }


}

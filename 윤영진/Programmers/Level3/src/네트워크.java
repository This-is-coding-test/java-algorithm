import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 네트워크 {
    static List<ArrayList<Integer>> listGraph = new ArrayList<>();
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i=0;i<n; i++) {
            listGraph.add(new ArrayList());
        }


        for (int i = 0; i< n; i++){
            for (int j =0;j<n;j++) {
                if(computers[i][j] != 0) {
                    listGraph.get(i).add(j);
                    listGraph.get(j).add(i);
                }
            }
        }

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public void dfs(int v) {
        visited[v] = true;

        for (Integer vex: listGraph.get(v)) {
            if (!visited[vex]) {
                dfs(vex);
            }
        }

    }
}

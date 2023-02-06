import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀_프로젝트 {

    // 이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다.
    // 프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다.
    // 프로젝트 팀을 구성하기 위헤, 모든 학생들은 프로젝트를 함꼐하고 싶은 학생을 선택해야 한다.
    // 혼자하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.

    static int T, n;
    static int[] arr;
    static boolean[] visited, done;
    static boolean flag = false;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            cnt = 0;

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }

            }
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        visited[n] = true; // 1
        int next = arr[n]; // 3
        if (!visited[next]) dfs(next);
        else {
            if (!done[next]) {
                cnt++;
                done[next] = true;
                while (next != n) {
                    cnt++;
                    next = arr[next];
                    done[next] = true;
                }
            }
        }
        done[n] = true;


    }
}

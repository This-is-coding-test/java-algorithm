import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리멘더링 {
    // 백준시는 N개의 구역으로 나누어져 있고, 구역은 1번부터 N번까지 번호가 매겨져 있다.
    // 구역을 두 개의 선거구로 나눠여 하고, 각 구역은 두 선거구 중 하나에 포함
    // 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결

    // 공평하게 선거구를 나누기 위해 두 선거구에 포함된 인구의 차이를 최소
    static int N;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] arr;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        selected = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                adjList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N - 1; i++) {
            comb(i, 0, 1);
        }

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    private static void comb(int end, int depth, int start) {
        if (depth == end) {
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (selected[i]) teamA.add(i);
                else teamB.add(i);
            }
            if (isPossible(teamA, teamB)) {
                int tmp = getResult(teamA, teamB);
                answer = Math.min(answer, tmp);
            }
        } else {
            for (int i = start; i <= N; i++) {
                selected[i] = true;
                comb(end, depth + 1, i + 1);
                selected[i] = false;
            }

        }
    }

    private static int getResult(ArrayList<Integer> teamA, ArrayList<Integer> teamB) {

        int sumA = 0;
        int sumB = 0;

        for (Integer t : teamA) {
            sumA += arr[t];
        }

        for (Integer t : teamB) {
            sumB += arr[t];
        }
        return Math.abs(sumA - sumB);
    }

    private static boolean isPossible(ArrayList<Integer> teamA, ArrayList<Integer> teamB) {
        if (bfs(teamA) && bfs(teamB)) return true;
        return false;
    }

    private static boolean bfs(ArrayList<Integer> team) {
        HashSet<Integer> set = new HashSet<>(team);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(team.get(0));
        set.remove(team.get(0));

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : adjList.get(now)) {
                if (set.contains(next)) {
                    set.remove(next);
                    queue.offer(next);
                }
            }
        }
        return set.isEmpty();
    }
}

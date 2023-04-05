import java.util.*;

class 최소_환승_경로_2 {

    class Info {
        int station; // 역 정보
        int route; // 현재 노드 정보

        public Info(int station, int route) {
            this.station = station;
            this.route = route;
        }
    }

    // 역 번호가 최대 1,000,000개 이므로 인접리스트를 활용하면 메모리가 크게 낭비 -> 해싱 활용
    // 해싱 -> {역 번호, Set<>()}
    // 레벨 탐색?
    HashMap<Integer, HashSet<Integer>> graph;
    int n; // 노선 개수
    int[][] route;

    public int solution(int[][] routes, int s, int e) {
        int answer = 0;
        graph = new HashMap<>();
        n = routes.length;
        route = routes;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new HashSet<>());
                graph.get(routes[i][j]).add(i);
            }
        }

        return bfs(s, e);
    }

    private int bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>(); // 역
        boolean[] visitedLine = new boolean[n]; // 노선 배열
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer station = queue.poll(); // 역 -> 1

                for (int line : graph.get(station)) {
                    if (visitedLine[line]) continue;
                    visitedLine[line] = true;
                    for (int num : route[line]) {
                        if(num == e) return L;
                        queue.offer(num);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        최소_환승_경로_2 T = new 최소_환승_경로_2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
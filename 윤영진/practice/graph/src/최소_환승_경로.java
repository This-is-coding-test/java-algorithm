import java.util.*;

class 최소_환승_경로 {

    class Info {
        int station; // 역 정보
        int route; // 현재 노드 정보
        int count;

        public Info(int station, int route, int count) {
            this.station = station;
            this.route = route;
            this.count = count;
        }
    }

    ArrayList<ArrayList<Integer>> route; // 각 노선에 역 정보
    ArrayList<ArrayList<Integer>> station; // 역마다 노선 정보
    int n; // 역 최대 개수

    public int solution(int[][] routes, int s, int e) {
        int answer = 0;
        route = new ArrayList<>();
        station = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            route.add(new ArrayList<>());
        }
        n = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                n = Math.max(n, routes[i][j]);
            }
        }

        for (int i = 0; i <= n; i++) {
            station.add(new ArrayList<>());
        }

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                route.get(i).add(routes[i][j]);
                station.get(routes[i][j]).add(i);
            }
        }

        return bfs(s, e);
    }

    private int bfs(int s, int e) {
        Queue<Info> queue = new LinkedList<>();
        boolean[] visitedRoute = new boolean[route.size()]; // 노선
        boolean[] visitedStation = new boolean[n + 1]; // 역
        visitedStation[s] = true;
        for (Integer route : station.get(s)) {
            queue.offer(new Info(s, route, 0));
            visitedRoute[route] = true;
        }
        while(!queue.isEmpty()) {

            Info info = queue.poll();
            if(info.station == e) return info.count;

            // 1 2
            for(Integer st : route.get(info.route)) { // 해당 루트에 존재하는 역
                if(!visitedStation[st]) {
                    visitedStation[st] = true;
                    queue.offer(new Info(st, info.route, info.count));
                }

                for(Integer route : station.get(st)) { // 환승
                    if(!visitedRoute[route]) {
                        visitedRoute[route] = true;
                        queue.offer(new Info(st, route, info.count + 1));
                    }
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        최소_환승_경로 T = new 최소_환승_경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
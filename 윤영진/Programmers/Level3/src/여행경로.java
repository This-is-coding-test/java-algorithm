import java.util.*;

class 여행경로 {
    // 주어진 항공권을 모두 이용하여 여행경로를 짜려고 한다.
    // 항상 "ICN" 공항에서 출발

    static String[][] ticket;
    static ArrayList<String> allRoutes = new ArrayList<>();
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticket = tickets;
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN");

        Collections.sort(allRoutes);
        return allRoutes.get(0).split(" ");
    }

    public void dfs(int depth, String start, String route) {
        if (depth == ticket.length) {
            allRoutes.add(route);
        } else {
            for (int i = 0; i < ticket.length; i++) {
                if (ticket[i][0].equals(start) && !visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, ticket[i][1], route + " " + ticket[i][1]);
                    visited[i] = false;
                }
            }
        }

    }
}
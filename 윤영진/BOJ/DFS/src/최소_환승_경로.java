import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소_환승_경로 {
    // 지하철 노선에 대한 정보가 주어졌을 때, 출발지에서 목적지까지의 최소 환승 경로를 구하는 프로그램

    static class Pair {
        int station; // 역 정보
        int line; // 현재 노드 정보
        int count;

        public Pair(int station, int line, int count) {
            this.station = station;
            this.line = line;
            this.count = count;
        }
    }

    static int N, L; // N - 역 개수, L - 노선 개수
    static int s, e; // 시작 역의 번호, 목적지 역의 번호
    static List<ArrayList<Integer>> stations = new ArrayList<>(); // 각 역에 어떤 노선을 포함하는지 리스트
    static List<ArrayList<Integer>> lines = new ArrayList<>(); // 노선에 어떤 역이 들어있는지 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        L = Integer.parseInt(tmp[1]);

        for (int i = 0; i <= N; i++) {
            stations.add(new ArrayList<>());
        }
        for (int i = 0; i <= L; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 1; i <= L; i++) { // i호선
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < st.length - 1; j++) {
                int num = Integer.parseInt(st[j]);
                lines.get(i).add(num);
                stations.get(num).add(i);
            }
        }
        String[] temp = br.readLine().split(" ");
        s = Integer.parseInt(temp[0]);
        e = Integer.parseInt(temp[1]);

        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[] visitedStation = new boolean[N + 1];
        boolean[] visitedLine = new boolean[L + 1];
        visitedStation[s] = true;

        PriorityQueue<Pair> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (Integer line : stations.get(s)) {
            pQ.offer(new Pair(s, line, 0));
            visitedLine[line] = true; // 해당 노선 visit
        }

        while (!pQ.isEmpty()) {
            Pair p = pQ.poll();
            System.out.println(p);
            if (p.station == e) return p.count;

            for (Integer nextStation : lines.get(p.line)) {
                if (visitedStation[nextStation]) continue;
                visitedStation[nextStation] = true;
                pQ.offer(new Pair(nextStation, p.line, p.count));

                for (Integer nextLine : stations.get(nextStation)) {
                    if (!visitedLine[nextLine]) {
                        visitedLine[nextLine] = true;
                        pQ.offer(new Pair(nextStation, nextLine, p.count + 1));
                    }
                }
            }
        }
        return -1;
    }

}

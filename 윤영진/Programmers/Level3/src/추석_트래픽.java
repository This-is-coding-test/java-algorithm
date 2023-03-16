import java.util.*;

public class 추석_트래픽 {

    static class Pair {
        int time;
        int type;

        public Pair(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    static List<Pair> pairs = new ArrayList<>();

    public static int solution(String[] lines) throws Exception {
        int max = 0;
        for (String line : lines) {
            String[] tmp = line.split(" ");
            String time = tmp[1];
            int t = timeToSec(time);
            String duration = tmp[2];
            int d = getDuration(duration);
            pairs.add(new Pair(t - d, 0)); // 시작점
            pairs.add(new Pair(t + 1000, 1)); // 종료점
        }

        Collections.sort(pairs, (o1, o2) -> o1.time - o2.time);

        int cnt = 0;
        for (Pair p : pairs) {
            if (p.type == 0) cnt++;
            else cnt--;

            max = Math.max(max, cnt);
        }
        return max;

    }

    private static int getDuration(String duration) {
        duration = duration.substring(0, duration.length() - 1);
        int d = (int) (Double.parseDouble(duration) * 1000);
        return d - 1;
    }

    private static int timeToSec(String time) {
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);
        int sec = (int) (Double.parseDouble(s[2]) * 1000);
        return 1000 * hour * 3600 + minute * 60 * 1000 + sec;
    }
}

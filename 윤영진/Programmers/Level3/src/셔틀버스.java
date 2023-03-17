import java.util.*;

public class 셔틀버스 {

    // 9:00 부터 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        for (String tt : timetable) {
            String[] tmp = tt.split(":");
            int h = Integer.parseInt(tmp[0]) * 60;
            int min = Integer.parseInt(tmp[1]);
            pQ.offer(h + min);
        }

        int startTime = 540;
        int lastTime = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pQ.isEmpty()) {
                int currentTime = pQ.peek();
                if (currentTime <= startTime && total < m) {
                    pQ.poll();
                    total++;
                } else break;
                lastTime = currentTime - 1;
            }
            startTime += t;
        }

        if (total < m) lastTime = startTime - t;
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }
}

package 결혼식;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TimeInfo implements Comparable<TimeInfo> {
    public int time;
    public int type;

    public TimeInfo(int time, int type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(TimeInfo o) {
        // 시간이 같다면 가는 시간을 우선으로
        if (this.time == o.time) return o.type - this.type;
        else return this.time - o.time;
    }
}

public class Main {

    public int solution(List<TimeInfo> timeInfos) {
        Collections.sort(timeInfos);

        int max = 0, cnt = 0;

        for (TimeInfo timeInfo : timeInfos) {
            if (timeInfo.type == 2) cnt--; // 가는 시간일 경우
            else { // 오는 시간일 경우
                cnt++;
                if (cnt > max) {
                    max = cnt;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<TimeInfo> timeInfos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            timeInfos.add(new TimeInfo(scanner.nextInt(), 1));
            timeInfos.add(new TimeInfo(scanner.nextInt(), 2));
        }

        Main main = new Main();
        int answer = main.solution(timeInfos);
        System.out.println(answer);
    }

}

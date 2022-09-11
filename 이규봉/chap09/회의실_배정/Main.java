package 회의실_배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    public int startAt;
    public int endAt;

    public Meeting(int startAt, int endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.endAt == o.endAt) return this.startAt - o.endAt;
        else return this.endAt - o.endAt;
    }
}

public class Main {

    public int solution(List<Meeting> meetings) {
        Collections.sort(meetings);

        int lastEndAt = 0, count = 0;

        for (Meeting meeting : meetings) {
            if (meeting.startAt >= lastEndAt) {
                lastEndAt = meeting.endAt;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(scanner.nextInt(), scanner.nextInt()));
        }

        Main main = new Main();
        int answer = main.solution(meetings);
        System.out.println(answer);
    }

}

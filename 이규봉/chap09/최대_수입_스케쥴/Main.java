package 최대_수입_스케쥴;

import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int profit;
    public int limit;

    public Lecture(int profit, int limit) {
        this.profit = profit;
        this.limit = limit;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.limit - this.limit;
    }
}

public class Main {
    static int max = Integer.MIN_VALUE;

    public int solution(int n, List<Lecture> lectures) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(lectures);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectures.get(j).limit < i) break;
                pQ.offer(lectures.get(j).profit);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int profit = scanner.nextInt();
            int limit = scanner.nextInt();
            lectures.add(new Lecture(profit, limit));
            if (max < limit) max = limit;
        }

        Main main = new Main();
        int answer = main.solution(n, lectures);
        System.out.println(answer);
    }

}

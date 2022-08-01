package 공주_구하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                // 맨 앞 원소 빼서 마지막에 넣기
                q.offer(q.poll());
            }
            // k 번째 원소는 poll
            q.poll();
        }

        return q.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Main main = new Main();
        int answer = main.solution(n, k);
        System.out.println(answer);
    }

}

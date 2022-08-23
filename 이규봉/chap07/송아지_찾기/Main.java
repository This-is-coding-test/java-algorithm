package 송아지_찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int[] dx = {1, -1, 5};
    boolean[] visit = new boolean[10001];
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        Q.offer(s);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            // 큐의 원소들 전부 꺼내기
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                // 맞으면 현재 레벨 반환
                if (x == e) {
                    return L;
                }
                // 자식 노드 큐에 삽입
                for (int j = 0; j < 3; j++) {
                    int nx = x + dx[j];
                    if (nx >= 1 && nx <= 10000 && !visit[nx]) {
                        visit[nx] = true;
                        Q.offer(nx);
                    }
                }
            }
            // 큐의 원소들 전부 꺼내면 레벨 1 증가시켜주기
            L++;
        }

        return L;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        Main main = new Main();
        int answer = main.BFS(s, e);
        System.out.println(answer);
    }

}

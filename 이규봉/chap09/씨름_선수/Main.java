package 씨름_선수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Player implements Comparable<Player> {
    public int height;
    public int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        // 키를 기준으로 내림차순 정렬
        return o.height - this.height;
    }
}

public class Main {

    public int solution(List<Player> players) {
        int count = 0, max = Integer.MIN_VALUE;

        Collections.sort(players);

        // 순회하면서 몸무게가 앞 사람들보다 크면 선발됨 (키는 앞 사람들보다 작으므로 몸무게가 더 나가야 선발됨)
        for (Player player : players) {
            if (player.weight > max) {
                count++;
                max = player.weight;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            players.add(new Player(scanner.nextInt(), scanner.nextInt()));
        }

        Main main = new Main();
        int answer = main.solution(players);
        System.out.println(answer);
    }

}

package 등수구하기;

import java.util.Scanner;

public class Main {

    public int[] solution(int[] scores) {
        int[] rankings = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int ranking = 1;
            for (int j = 0; j < scores.length; j++) {
                if (scores[i] < scores[j]) {
                    ranking++;
                }
            }
            rankings[i] = ranking;
        }

        return rankings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        Main main = new Main();
        int[] rankings = main.solution(scores);
        for (int ranking : rankings) {
            System.out.print(ranking + " ");
        }
    }

}

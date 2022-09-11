package 가장_높은_탑_쌓기;

import java.util.Arrays;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    public int area;
    public int height;
    public int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        // 밑면의 넓이를 기준으로 내림차순 정렬
        return o.area - this.area;
    }
}

public class Main {

    public int solution(int n, Brick[] bricks) {
        Arrays.sort(bricks);
        int[] dy = new int[n];
        dy[0] = bricks[0].height;
        int answer = dy[0];

        for (int i = 1; i < n; i++) {
            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks[j].weight > bricks[i].weight && dy[j] > maxHeight) {
                    maxHeight = dy[j];
                }
            }
            dy[i] = maxHeight + bricks[i].height;
            answer = Math.max(dy[i], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Brick[] bricks = new Brick[n];

        for (int i = 0; i < n; i++) {
            int area = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            bricks[i] = new Brick(area, height, weight);
        }
        Main main = new Main();
        int answer = main.solution(n, bricks);
        System.out.println(answer);
    }

}

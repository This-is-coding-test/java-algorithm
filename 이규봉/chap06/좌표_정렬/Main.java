package 좌표_정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Coordinate implements Comparable<Coordinate> {
        int a;
        int b;

        public Coordinate(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Coordinate o) {
            /* 오름차순 */
            // this가 크면 양수 반환
            // 같으면 0 반환
            // this가 작으면 음수 반환
            if (this.a == o.a) {
                return this.b - o.b;
            } else {
                return this.a - o.a;
            }
        }
    }

    public List<Coordinate> solution(List<Coordinate> coordinates) {
        Collections.sort(coordinates);
        return coordinates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            coordinates.add(new Coordinate(a, b));
        }

        Main main = new Main();
        List<Coordinate> answer = main.solution(coordinates);
        answer.forEach(coordinate -> System.out.println(coordinate.a + " " + coordinate.b));
    }

}

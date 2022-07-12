package 가장_짧은_문자거리;

import java.util.Scanner;

public class Main {

    public String solution(String str, char c) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int dist = Integer.MAX_VALUE;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    dist = Math.min(dist, Math.abs(j - i));
                }
            }
            sb.append(dist).append(" ");
        }

        /* 양쪽에서 순회하는 방법 */
//        int dist = 1000;
//        int[] result = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == c) {
//                dist = 0;
//            } else {
//                dist += 1;
//            }
//            result[i] = dist;
//        }
//
//        dist = 1000;
//        for (int i = str.length() - 1; i > -1; i--) {
//            if (str.charAt(i) == c) {
//                dist = 0;
//            } else {
//                dist += 1;
//            }
//            result[i] = Math.min(result[i], dist);
//        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        Main main = new Main();
        String result = main.solution(str, c);
        System.out.println(result);
    }

}

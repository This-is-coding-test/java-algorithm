package 문자열_압축;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        /* 이전 문자와 비교 */
//        int count = 1;
//        char prev = str.charAt(0);
//        str = str.substring(1);
//        StringBuilder sb = new StringBuilder();
//
//        for (char c : str.toCharArray()) {
//            if (c == prev) {
//                count++;
//            } else {
//                sb.append(prev);
//                prev = c;
//                if (count > 1) {
//                    sb.append(count);
//                    count = 1;
//                }
//            }
//        }
//        sb.append(prev);
//        if (count > 1) {
//            sb.append(count);
//        }

        /* 다음 문자와 비교 */
        str += " ";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            } else {
                count++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        String result = main.solution(str);
        System.out.println(result);
    }

}

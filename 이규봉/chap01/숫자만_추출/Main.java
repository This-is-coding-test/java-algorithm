package 숫자만_추출;

import java.util.Scanner;

public class Main {

    public int solution(String str) {
        StringBuilder sb = new StringBuilder();

        int result = 0;
        for (char c : str.toCharArray()) {
            /* 아스키 코드 이용 */
            if (48 <= c && c <= 57) {
                // 뒷 자리에 누적 (아스키 번호로 연산되므로 숫자 0에 해당하는 48 빼주기)
                result = result * 10 + (c - 48);
            }

            /* isDigit 메서드 이용 */
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        int result = main.solution(str);
        System.out.println(result);
    }

}

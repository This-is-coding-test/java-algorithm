package 회문_문자열;

import java.util.Scanner;

public class Main {

    public boolean solution(String str) {
        str = str.toLowerCase();

        /* StringBuilder 이용 */
//        StringBuilder sb = new StringBuilder(str);
//        return sb.reverse().toString().equals(str);

//        return sb.reverse().toString().equalsIgnoreCase(str);


        /* chatAt 이용 */
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        String result = main.solution(str) ? "YES" : "NO";
        System.out.println(result);
    }

}

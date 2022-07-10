package 유효한_팰린드롬;

import java.util.Scanner;

public class Main {

    public boolean solution(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//
//        char[] chars = str.toLowerCase().toCharArray();
//
//        while (left < right) {
//            if (!Character.isAlphabetic(chars[left])) {
//                left++;
//            } else if (!Character.isAlphabetic(chars[right])) {
//                right--;
//            } else {
//                if (chars[left] != chars[right]) {
//                    return false;
//                }
//                left++;
//                right--;
//            }
//        }
//        return true;

        /* replaceAll 정규식 이용 */
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        String result = main.solution(str) ? "YES" : "NO";
        System.out.println(result);
    }

}
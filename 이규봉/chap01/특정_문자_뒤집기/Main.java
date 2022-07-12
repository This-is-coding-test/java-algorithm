package 특정_문자_뒤집기;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        int left = 0;
        int right = str.length() - 1;

        char[] chars = str.toCharArray();

        while (left < right) {
            if (!Character.isAlphabetic(chars[left])) {
                left++;
            } else if (!Character.isAlphabetic(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        String result = main.solution(str);

        System.out.println(result);
    }

}

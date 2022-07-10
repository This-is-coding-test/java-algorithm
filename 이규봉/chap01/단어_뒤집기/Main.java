package chap01.단어_뒤집기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public List<String> solution(List<String> strList) {
        List<String> result = new ArrayList<>();

        for (String str : strList) {
            /* StringBuiler 이용 */
//            StringBuilder stringBuilder = new StringBuilder(str);
//            result.add(stringBuilder.reverse().toString());

            /* 직접 뒤집기 */
            char[] charArr = str.toCharArray();
            int left = 0, right = str.length() - 1;

            while (left < right) {
                char temp = charArr[left];
                charArr[left] = charArr[right];
                charArr[right] = temp;

                left++;
                right--;
            }

            result.add(String.valueOf(charArr));
        }

        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<String> strList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            strList.add(scanner.next());
        }

        for (String str : main.solution(strList)) {
            System.out.println(str);
        }
    }

}

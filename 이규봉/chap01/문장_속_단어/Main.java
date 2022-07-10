package chap01.문장_속_단어;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String maxLengthWord = "";

        /* split 이용 */
//        String[] strArr = str.split(" ");
//
//        for (String s : strArr) {
//            if (s.length() > maxLengthWord.length()) {
//                maxLengthWord = s;
//            }
//        }

        /* indexOf, subString 이용 */
        int pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String s = str.substring(0, pos);
            if (s.length() > maxLengthWord.length()) {
                maxLengthWord = s;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > maxLengthWord.length()) {
            maxLengthWord = str;
        }

        return maxLengthWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Main main = new Main();
        String maxLengthWord = main.solution(str);

        System.out.println(maxLengthWord);
    }

}

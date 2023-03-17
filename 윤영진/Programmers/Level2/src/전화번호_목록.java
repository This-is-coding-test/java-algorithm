import java.util.Arrays;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            String curr = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                String check = phone_book[j];
//                if (curr.length() < check.length()) continue;

                if (curr.equals(check.substring(0, curr.length()))) {
                    return false;
                }
            }
        }
        return true;
    }
}

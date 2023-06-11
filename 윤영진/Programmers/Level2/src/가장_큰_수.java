import java.util.ArrayList;
import java.util.Collections;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0 ; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (list.get(0).equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String st : list) {
            sb.append(st);
        }
        return sb.toString();
    }
}

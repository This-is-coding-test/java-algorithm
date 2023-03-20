import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뉴스_클러스터링 {

    public int solution(String str1, String str2) {
        List<String> multiSet1 = new ArrayList<>();
        List<String> multiSet2 = new ArrayList<>();
        List<String> union = new ArrayList<>(); // 합집합
        List<String> intersection = new ArrayList<>(); // 교집합

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // a = {AA, AA}
        // b = {AA, AA, AA}
        // a 교 b = {AA, AA}
        // a 합 b = {AA, AA, AA}

        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                multiSet1.add(c1 + "" + c2);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                multiSet2.add(c1 + "" + c2);
            }
        }

        for (String s : multiSet1) {
            if (multiSet2.remove(s)) intersection.add(s);
            union.add(s);
        }
        union.addAll(multiSet2);

        if(union.size() == 0) return 65536;

        double answer = (double)intersection.size() / (double)union.size();

        return (int) (answer * 65536);
    }

}

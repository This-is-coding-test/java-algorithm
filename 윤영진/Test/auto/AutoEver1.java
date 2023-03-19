package Test.auto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AutoEver1 {
    // APPLEZZZZZZZZ
    // APPSTOREZZZZZ
    // APPENDZZZZZZZ
    // AIRPLANEZZZZZ

    // 트라이? -> 찾아보기
    // A라는 문자열과 가장 비슷한 문자열 B을 찾고 ==> 사전순 정렬을 하면 바로 앞이나 바로 뒤중에 하나 -> 둘만 비교
    // A랑 B가 10번째까지 같았다면 A를 11번째까지 압축하면된다.
    // 문자열의 유사성을 판달할 때 정렬을 이용하는 방법
    // 만약 정렬을 이용하지 않고 비슷한 문자열을 찾기 위해서는 N^2

    static int N;
    static String[] strings;
    static Map<String, Integer> words = new HashMap<>();
    static String[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new String[N];
        results = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
            words.put(strings[i], i);
        }

        solution();
    }

    private static void solution() {

        Arrays.sort(strings); // 단어 사전순 정렬

        for (int i = 0; i < strings.length; i++) {
            int prevLen = getCommonPrefixLength(i - 1, i);
            int nextLen = getCommonPrefixLength(i, i + 1);

            Integer idx = words.get(strings[i]);
            int len = Math.max(prevLen, nextLen) + 1;
            results[idx] = strings[i].substring(0, len);
        }

        for (String result : results) {
            System.out.println(result);
        }


    }

    private static int getCommonPrefixLength(int i, int j) { // i번쨰 단어와 j번째 단어의 최대 공통 prefix
        if (i < 0 || j < 0 || i >= strings.length || j >= strings.length) return 0;

        for (int k = 0; k < 13; k++) {
            if (strings[i].charAt(k) != strings[j].charAt(k)) {
                return k;
            }
        }
        return -1;
    }
}

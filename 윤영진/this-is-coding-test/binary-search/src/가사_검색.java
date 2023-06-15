import java.util.ArrayList;
import java.util.Collections;

public class 가사_검색 {
    // 키워드 길이 -> 1 이상 10,000 이하
    ArrayList<ArrayList<String>> arr = new ArrayList<>();
    ArrayList<ArrayList<String>> reverseArr = new ArrayList<>();

    public int[] solution(String[] words, String[] queries) {

        for (int i = 0; i <= 10000; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        for (String word : words) {
            int len = word.length();
            arr.get(len).add(word);
            reverseArr.get(len).add(new StringBuilder(word).reverse().toString());
        }

        for (int i = 1; i <= 10000; i++) {
            if (arr.get(i).isEmpty()) continue;

            Collections.sort(arr.get(i));
            Collections.sort(reverseArr.get(i));
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if (query.charAt(0) != '?') {
                answer[i] = countByRange(arr.get(len), query.replaceAll("[?]", "a"), query.replaceAll("[?]", "z"));
            } else {
                query = new StringBuilder(query).reverse().toString();
                answer[i] = countByRange(reverseArr.get(len), query.replaceAll("[?]", "a"), query.replaceAll("[?]", "z"));
            }
        }

        return answer;
    }

    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {

        int leftIdx = lowerBound(arr, leftValue, 0, arr.size());
        int rightIdx = upperBound(arr, rightValue, 0, arr.size());
        return rightIdx - leftIdx;
    }

    public int lowerBound(ArrayList<String> arr, String leftValue, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            // front > froaa -> mid = 2 (start = 0, end = 5) -> end = 2
            // frodo > froaa -> mid = 1 (start = 0, end = 2) -> end = 1
            // frame < froaa -> mid = 0 (start = 0, end = 1) -> start = 1
            if (arr.get(mid).compareTo(leftValue) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int upperBound(ArrayList<String> arr, String rightValue, int start, int end) {

        while (start < end) {
            int mid = (start + end) / 2;
            // front < frozz -> mid = 2 (start = 0, end = 5) -> start = 3
            // kakao > frozz -> mid = 4 (start = 3, end = 5) -> end = 4
            // frost < frozz -> mid = 3 (start = 3, end = 4) -> start = 4
            // start = 4 / end = 4 break;
            if (arr.get(mid).compareTo(rightValue) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

}

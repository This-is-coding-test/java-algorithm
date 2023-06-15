import java.util.*;

class 양궁대회 {
    int[] ryan;
    int[] apeach;
    int maxDiff = -1;
    ArrayList<int[]> results = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        ryan = new int[11];
        apeach = info;

        dfs(n, 0, 0);
        if (maxDiff == -1) return new int[]{-1};

        Collections.sort(results, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });

        return results.get(0);
    }

    public void dfs(int n, int depth, int start) {
        if (depth == n) {
            calc();
        } else {
            for (int i = start; i < 11; i++) {
                ryan[i]++;
                dfs(n, depth + 1, i);
                ryan[i]--;
            }
        }
    }

    public void calc() {
        int rSum = 0;
        int aSum = 0;

        for (int i = 0; i < 10; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i]) aSum += (10 - i);
            else rSum += (10 - i);
        }

        if (rSum > aSum) {
            int diff = rSum - aSum;
            if (maxDiff < diff) {
                maxDiff = diff;
                results.clear();
                results.add(ryan.clone());
            } else if (maxDiff == diff) {
                results.add(ryan.clone());
            }
        }
    }
}
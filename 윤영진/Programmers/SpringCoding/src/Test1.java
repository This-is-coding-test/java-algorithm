import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

    // 복권은 여러 개 있지만, 그중에서 하나만 살 수 있다.
    // 당첨자 수, 구매한 사람 수, 당첨 금액

    // 1. 당첨자 수보다 구매한 사람 수가 같거나 적을 경우 구매한 사람 모두가 당첨
    // 당첨자 수 <= 구매한 사람

    // 2. 당첨자 수보다 구매한 사람 수가 많을 경우 무작위로 당첨자 수만큼 당첨자

    // 당첨 확률이 가장 높은 복권 -> 당첨 확률이 높은 복권이 여러 개라면 당첨 금액이 제일 높은 복권

    static class Lottery implements Comparable<Lottery> {
        int num; // 복권 번호
        int percent; // 확률
        int price; // 가격

        public Lottery(int num, int percent, int price) {
            this.num = num;
            this.percent = percent;
            this.price = price;
        }

        @Override
        public int compareTo(Lottery o) {
            if (this.percent != o.percent) return o.percent - this.percent;
            return o.price - this.price;
        }
    }

    static int n;
    static List<Lottery> lotteryList = new ArrayList<>();

    public static int solution(int[][] lotteries) {
        n = lotteries.length;

        for (int i = 0; i < n; i++) {
            float n1 = lotteries[i][0];
            float n2 = lotteries[i][1];
            int price = lotteries[i][2];

            if (n1 >= n2 + 1) {
                lotteryList.add(new Lottery(i + 1, 1000000, price));
            } else {
                int p = (int) ((n1 / (n2 + 1)) * 1000000);
                lotteryList.add(new Lottery(i + 1, p, price));
            }
        }

        Collections.sort(lotteryList);
        return lotteryList.get(0).num;
    }

}
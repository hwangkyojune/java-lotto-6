package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputService {
    private static final String informIssuedLottoCount = "%d개를 구매했습니다.";
    private static final String informRankCount =  " - %d개";
    public static void printLottoCount(int lottoCount){
        System.out.println(String.format(informIssuedLottoCount,lottoCount));
    }

    public static void printIssuedLotto(List<Lotto> lottoes){
        lottoes.stream().forEach((lotto) ->{
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        });
    }

    public static void printRankStatus(Rank rank){
        System.out.print(rank.getStatus());
    }

    public static void printRankCount(int count){
        System.out.println(String.format(informRankCount,count));
    }

    public static void printAllWinRecord(Map<Rank,Integer> rankingResult){
        rankingResult.keySet().stream().forEach((rank)->{
            printRankStatus(rank);
            printRankCount(rankingResult.get(rank));
                });
    }

    public static void printReturnOfRate(double profitRate){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",profitRate));
    }
}

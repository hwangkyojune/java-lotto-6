package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static lotto.ValidateService.validateProperMoney;

public class LottoMarketService {
    static private final int LOTTO_NUM_SIZE = 6;
    static private final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottoes(int lottoCount){
        List<Lotto> lottoes = new ArrayList<>();
        Supplier<Integer> lottoNumSupplier = new LottoNumSupplier();
        for(int i=0;i<lottoCount;i++){
            List<Integer> lottoNums = generateNonDuplicatedNums(lottoNumSupplier);
            lottoNums.sort(Integer::compare);
            lottoes.add(new Lotto(lottoNums));
        }
        return lottoes;
    }

    public List<Integer> generateNonDuplicatedNums(Supplier<Integer> lottoNumSupplier){
        List<Integer> lottoNumbers = new ArrayList<>();
        while(lottoNumbers.size() < LOTTO_NUM_SIZE){
            int candidateNum = lottoNumSupplier.get();
            boolean isDuplicated = lottoNumbers.stream()
                    .anyMatch(num->num.equals(candidateNum));
            System.out.println(isDuplicated);
            if(!isDuplicated){
                lottoNumbers.add(candidateNum);
            }
        }
        return lottoNumbers;
    }

    public int calculateLottoCount(int money){
        int lottoCount = money/LOTTO_PRICE;
        return lottoCount;
    }
}

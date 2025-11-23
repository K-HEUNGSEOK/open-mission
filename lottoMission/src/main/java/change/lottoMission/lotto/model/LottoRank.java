package change.lottoMission.lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int rewardMoney;


    LottoRank(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static LottoRank findRank(int count, boolean bonusMatch) {
        if (count == 5) {
            if (bonusMatch) {
                return SECOND;
            }
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElse(MISS);
    }
}
